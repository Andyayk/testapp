package com.example.demo.service;
import com.example.demo.model.AppUser;
import com.example.demo.model.FavouriteJob;
import com.example.demo.model.FavouriteJobKey;
import com.example.demo.model.Job;
import com.example.demo.repository.AppUserRepo;
import com.example.demo.repository.FavouriteJobRepo;
import com.example.demo.repository.JobRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
    public List<Job> findAllJobs() {
        return jobRepo.findAll();
    }

    //create job
    public String addJob(Job job) {
        jobRepo.save(job);
        return "Job Added!";
    }

    //delete job
    public String deleteJob(Job job) {
        jobRepo.delete(job);
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

    public List<String> findFavouritesList(HashMap<String, Object> payload) {
/*        List<String> favouritesList = new ArrayList<>();

        DocumentReference docRef = firestoreDB.collection("appuser").document(payload.get("employeeId").toString());

        try {
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            favouritesList = (ArrayList) document.get("favourites");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        return null;
    }

    public List<Job> findAllFavouritesJobs(HashMap<String, Object> payload) {
/*        List<Job> jobList = new ArrayList<>();
        List<String> favouritesList = findFavouritesList(payload);

        for (String favourite : favouritesList) {
            DocumentReference docRef = firestoreDB.collection("job").document(favourite);

            try {
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document = future.get();

                String jobId = document.getId();
                String jobTitle = document.getString("jobTitle");
                String jobDescription = document.getString("jobDescription");
                String datePosted = document.getString("datePosted");
                Job eachJob = new Job(jobId, jobTitle, jobDescription, datePosted);

                jobList.add(eachJob);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/

        return null;
    }

    public String favouriteJob(HashMap<String, Object> payload) {
        Long employeeId = parseLong(payload.get("employeeId").toString()); //convert to long
        Long jobId = parseLong(payload.get("jobId").toString()); //convert to long

        FavouriteJobKey favouriteJobKey = new FavouriteJobKey(employeeId, jobId); //create composite key

        AppUser appUser = appUserRepo.findByEmployeeId(employeeId); //get user
        Job job = jobRepo.findByJobId(jobId); //get job

        favouriteJobRepo.save(new FavouriteJob(favouriteJobKey, appUser, job));
        return "Job Added to Favourites!";
    }

    public String unfavouriteJob(HashMap<String, Object> payload) {
        Long employeeId = parseLong(payload.get("employeeId").toString()); //convert to long
        Long jobId = parseLong(payload.get("jobId").toString()); //convert to long

        FavouriteJobKey favouriteJobKey = new FavouriteJobKey(employeeId, jobId); //create composite key

        Optional<FavouriteJob> favouriteJob = favouriteJobRepo.findById(new FavouriteJobKey(employeeId, jobId));
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