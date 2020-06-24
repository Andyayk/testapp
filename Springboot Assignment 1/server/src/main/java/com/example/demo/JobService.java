package com.example.demo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class JobService {

    private static Firestore db;

    public JobService() {
        // Use a service account
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(System.getProperty("user.dir") + "\\serviceAccount.json");

            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Job> findAll() {
        //asynchronously retrieve all users
        ApiFuture<QuerySnapshot> query = db.collection("users").get();

        QuerySnapshot querySnapshot = null;
        try {
            querySnapshot = query.get();

            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                System.out.println("Job: " + document.getId());
                System.out.println("Job Title: " + document.getString("jobTitle"));
                System.out.println("Job Description: " + document.getString("jobDescription"));
                System.out.println("Date Posted: " + document.getString("datePosted"));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void addJob() {
        DocumentReference docRef = db.collection("job").document();
        //add document data using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("jobTitle", "Police");
        data.put("jobDescription", "Need to manage criminals");
        data.put("datePosted", "31-12-2020");
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

    }
}