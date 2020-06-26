package com.example.demo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class JobService {

    @Autowired
    private FirebaseConfig firebaseConfig;

    public List<Job> findAll() {
        Firestore db = firebaseConfig.getDb();
        List<Job> jobList = new ArrayList<>();

        //asynchronously retrieve all jobs
        ApiFuture<QuerySnapshot> query = db.collection("job").get();
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

    public void addJob(HashMap<String, Object> payload) {
        Firestore db = firebaseConfig.getDb();
        DocumentReference docRef = db.collection("job").document();

        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(payload);
    }

    //deleteJob
    public void deleteJob(HashMap<String, Object> payload) {
        Firestore db = firebaseConfig.getDb();
        db.collection("job").document(payload.get("jobId").toString()).delete();
    }

    //editJob
    public void editJob(HashMap<String, Object> payload) {
        Firestore db = firebaseConfig.getDb();

        DocumentReference docRef = db.collection("job").document(payload.get("jobId").toString());

        String jobTitle = payload.get("jobTitle").toString();
        String jobDescription = payload.get("jobTitle").toString();
        String datePosted = payload.get("datePosted").toString();

        if (!jobTitle.equals("")) {
            ApiFuture<WriteResult> future = docRef.update("jobTitle", jobTitle);
        }
        if (!jobDescription.equals("")) {
            ApiFuture<WriteResult> future = docRef.update("jobDescription", jobDescription);
        }
        if (!datePosted.equals("")) {
            ApiFuture<WriteResult> future = docRef.update("datePosted", datePosted);
        }
    }
}