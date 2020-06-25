package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AppUserService {

    @Autowired
    private FirebaseConfig firebaseConfig;

    public AppUser findUser(String username) {
        Firestore db = firebaseConfig.getDb();

        AppUser user = null;
        try {
            //asynchronously retrieve documents
            ApiFuture<QuerySnapshot> future =
                    db.collection("appuser").whereEqualTo("username", username).get();
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

    // login user
}