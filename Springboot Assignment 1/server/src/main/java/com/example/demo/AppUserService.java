package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
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

    public AppUser loginUser(HashMap<String, Object> payload) {
        Firestore db = firebaseConfig.getDb();

        AppUser user = null;

        //asynchronously retrieve documents
        ApiFuture<QuerySnapshot> query = db.collection("appuser").get();
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
}