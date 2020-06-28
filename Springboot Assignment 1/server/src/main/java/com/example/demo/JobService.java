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
}