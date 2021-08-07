package com.example.demo.service;
import com.example.demo.dto.FavouriteJobDTO;
import com.example.demo.dto.JobDTO;
import com.example.demo.model.AppUser;
import com.example.demo.model.FavouriteJob;
import com.example.demo.model.FavouriteJobKey;
import com.example.demo.model.Job;
import com.example.demo.repository.AppUserRepo;
import com.example.demo.repository.FavouriteJobRepo;
import com.example.demo.repository.JobRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

@Service
public class JobService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private FavouriteJobRepo favouriteJobRepo;

    //return all jobs from server
    public List<JobDTO> findAllJobs() {
        List<Job> jobList = jobRepo.retrieveAllByNotDeleted(0); //retrieve those that are not soft deleted

        Type listType = new TypeToken<List<JobDTO>>(){}.getType();
        List<JobDTO> jobDTOList = modelMapper.map(jobList, listType);

        return jobDTOList;
    }

    //create job
    public String addJob(Job job) {
        jobRepo.save(job);
        return "Job Added!";
    }

    //delete job
    public String deleteJob(Job job) {
        Job existingJob = jobRepo.findByJobId(job.getJobId());
        existingJob.setDeleted(1); //soft delete the job

        jobRepo.save(existingJob);
        return "Job Deleted!";
    }

    //edit job
    public String editJob(Job job) {
        Job currentJob = jobRepo.findByJobId(job.getJobId()); //retrieve current job

        String jobTitle = job.getJobTitle();
        String jobDescription = job.getJobDescription();
        String datePosted = job.getDatePosted();

        //update if there are values
        if (!jobTitle.equals("")) {
            currentJob.setJobTitle(jobTitle);
        }
        if (!jobDescription.equals("")) {
            currentJob.setJobDescription(jobDescription);
        }
        if (!datePosted.equals("")) {
            currentJob.setDatePosted(datePosted);
        }

        jobRepo.save(currentJob);

        return "Job Saved!";
    }

    public HashMap<String, ArrayList<String>> findAllUsersFavourites() {
/*        HashMap<String, ArrayList<String>> allUsersFavouritesMap = new HashMap<>();

        //asynchronously retrieve all favourites
        ApiFuture<QuerySnapshot> query = firestoreDB.collection("appuser").get();

        try {
            QuerySnapshot querySnapshot = query.get();

            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                String employeeId = document.getId();
                ArrayList<String> favouritesList = (ArrayList) document.get("favourites");

                allUsersFavouritesMap.put(employeeId, favouritesList);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        return null;
    }

    //return list of job id
    public List<Long> findFavouritesList(HashMap<String, Object> payload) {
        List<Long> favouritesList = new ArrayList<>();

        List<FavouriteJob> favouriteJobList = favouriteJobRepo.findAllByIdEmployeeId(parseLong(payload.get("employeeId").toString()));

        for (FavouriteJob favJob : favouriteJobList
             ) {
            favouritesList.add(favJob.getJob().getJobId());
        }
        return favouritesList;
    }

    //return list of jobs
    public List<FavouriteJobDTO> findAllFavouritesJobs(HashMap<String, Object> payload) {
        List<FavouriteJob> favouriteJobList = favouriteJobRepo.findAllByIdEmployeeId(parseLong(payload.get("employeeId").toString()));

        Type listType = new TypeToken<List<FavouriteJobDTO>>(){}.getType();
        List<FavouriteJobDTO> favouritesJobDTOList = modelMapper.map(favouriteJobList, listType);

        List<FavouriteJobDTO> filteredFavouritesJobDTOList = favouritesJobDTOList.stream()
                .filter(favJobDTO -> favJobDTO.getJob().getDeleted() == 0).collect(Collectors.toList()); //filter away jobs that are soft deleted

        return filteredFavouritesJobDTOList;
    }

    //user favourite a job
    public String favouriteJob(HashMap<String, Object> payload) {
        Long employeeId = parseLong(payload.get("employeeId").toString()); //convert to long
        Long jobId = parseLong(payload.get("jobId").toString()); //convert to long

        FavouriteJobKey favouriteJobKey = new FavouriteJobKey(employeeId, jobId); //create composite key

        AppUser appUser = appUserRepo.findByEmployeeId(employeeId); //get user
        Job job = jobRepo.findByJobId(jobId); //get job

        favouriteJobRepo.save(new FavouriteJob(favouriteJobKey, appUser, job));
        return "Job Added to Favourites!";
    }

    //user unfavourite a job
    public String unfavouriteJob(HashMap<String, Object> payload) {
        Long employeeId = parseLong(payload.get("employeeId").toString()); //convert to long
        Long jobId = parseLong(payload.get("jobId").toString()); //convert to long

        FavouriteJob favouriteJob = new FavouriteJob();
        FavouriteJobKey favouriteJobKey = new FavouriteJobKey(employeeId, jobId); //create composite key
        favouriteJob.setId(favouriteJobKey);

        favouriteJobRepo.delete(favouriteJob);
        return "Job Removed from Favourites!";
    }

    /*
    public AppUser findUser(String username) {
        AppUser user = null;

        //asynchronously retrieve documents
        ApiFuture<QuerySnapshot> future = firestoreDB.collection("appuser").whereEqualTo("username", username).get();

        try {
            //future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                user = document.toObject(AppUser.class);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return user;
    }

    public AppUser loginUser(HashMap<String, Object> payload) {
        AppUser user = null;

        //asynchronously retrieve documents
        ApiFuture<QuerySnapshot> query = firestoreDB.collection("appuser").get();

        try {
            QuerySnapshot querySnapshot = query.get();

            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            for (DocumentSnapshot document : documents) {
                String username = document.getString("username");
                String password = document.getString("password");

                if(username.equals(payload.get("username").toString()) && password.equals(payload.get("password").toString())) {
                    user = document.toObject(AppUser.class);
                    return user;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return user;
    }
    */
}