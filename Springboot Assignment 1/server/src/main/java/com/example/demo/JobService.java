package com.example.demo;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class JobService {

    private static List<Job> jobs = new ArrayList<>();
    private static long jobidCounter = 0;

    static {
        jobs.add(new Job(++jobidCounter, "Teacher", "Need to manage children", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Police", "Need to manage criminals", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Lawyer", "Need to manage law", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Doctor", "Need to manage patients", "31-12-2020"));

        // Use a service account
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("path/to/serviceAccount.json");

            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Job> findAll() {
        return jobs;
    }
}