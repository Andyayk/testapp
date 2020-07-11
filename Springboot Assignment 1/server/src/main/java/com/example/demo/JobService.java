package com.example.demo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.concurrent.ExecutionException;

@Service
public class JobService {

    @Autowired
    private Firestore firestoreDB;

    public List<Job> findAll() {
        List<Job> jobList = new ArrayList<>();

        //asynchronously retrieve all jobs
        ApiFuture<QuerySnapshot> query = firestoreDB.collection("job").get();
        QuerySnapshot querySnapshot = null;
        try {
            querySnapshot = query.get();

            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                String jobId = document.getId();
                String jobTitle = document.getString("jobTitle");
                String jobDescription = document.getString("jobDescription");
                String datePosted = document.getString("datePosted");
                Job eachJob = new Job(jobId, jobTitle, jobDescription, datePosted);

                jobList.add(eachJob);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return jobList;
    }

    public String addJob(HashMap<String, Object> payload) {
        firestoreDB.collection("job").document().set(payload); //add

        return "Job Added!";
    }

    public String deleteJob(HashMap<String, Object> payload) {
        firestoreDB.collection("job").document(payload.get("jobId").toString()).delete(); //delete

        return "Job Deleted!";
    }

    public String editJob(HashMap<String, Object> payload) {
        DocumentReference docRef = firestoreDB.collection("job").document(payload.get("jobId").toString());

        String jobTitle = payload.get("jobTitle").toString();
        String jobDescription = payload.get("jobDescription").toString();
        String datePosted = payload.get("datePosted").toString();

        //update
        if (!jobTitle.equals("")) {
            docRef.update("jobTitle", jobTitle);
        }
        if (!jobDescription.equals("")) {
            docRef.update("jobDescription", jobDescription);
        }
        if (!datePosted.equals("")) {
            docRef.update("datePosted", datePosted);
        }

        return "Job Saved!";
    }

    public List<Job> findUserFavourites(HashMap<String, Object> payload) {
        List<Job> jobList = new ArrayList<>();

        DocumentReference docRef = firestoreDB.collection("appuser").document(payload.get("employeeId").toString());

        ApiFuture<DocumentSnapshot> future = docRef.get();

        try {
            DocumentSnapshot document = future.get();

            List<String> favouritesList = (ArrayList) document.get("favourites");

            for (String favourite : favouritesList) {
                docRef = firestoreDB.collection("job").document(favourite);

                future = docRef.get();
                document = future.get();

                String jobId = document.getId();
                String jobTitle = document.getString("jobTitle");
                String jobDescription = document.getString("jobDescription");
                String datePosted = document.getString("datePosted");
                Job eachJob = new Job(jobId, jobTitle, jobDescription, datePosted);

                jobList.add(eachJob);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jobList;
    }

    public String favouriteJob(HashMap<String, Object> payload) {
        DocumentReference docRef = firestoreDB.collection("appuser").document(payload.get("employeeId").toString());

        docRef.update("favourites", FieldValue.arrayUnion(payload.get("jobId").toString())); //favourite
        return "Job Favourited!";
    }

    public String unfavouriteJob(HashMap<String, Object> payload) {
        DocumentReference docRef = firestoreDB.collection("appuser").document(payload.get("employeeId").toString());

        docRef.update("favourites", FieldValue.arrayRemove(payload.get("jobId").toString())); //unfavourite
        return "Job Unfavourite!";
    }

    /*
    @Autowired
    private Firestore firestoreDB;

    public AppUser findUser(String username) {

        AppUser user = null;
        try {
            //asynchronously retrieve documents
            ApiFuture<QuerySnapshot> future =
                    firestoreDB.collection("appuser").whereEqualTo("username", username).get();
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
        QuerySnapshot querySnapshot = null;
        try {
            querySnapshot = query.get();

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