package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private JobRepo jobRepo;

    public AppUser loginUser(String username, String password) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser != null && appUser.getPassword().equals(password) ) {
            return appUser;
        }
        return null;
    }

    public List<AppUser> findAllUsers() {
        return appUserRepo.findAll();
    }

    public AppUser findUser(String jobId) {
        return appUserRepo.retrieveByJobid(jobId);
    }

    public String addUser(HashMap<String, Object> payload) {
        Job job = jobRepo.findByJobId(payload.get("jobId").toString());

        if (job != null) {
            AppUser appUser = new AppUser(payload.get("jobId").toString(), payload.get("username").toString(), payload.get("password").toString(), payload.get("name").toString(), payload.get("email").toString(), "0", job);
            appUserRepo.save(appUser);
            return "Added";
        } else {
            return "Error";
        }
    }

    public String deleteUser(HashMap<String, Object> payload) {
        return null;
    }

    public String editUser(HashMap<String, Object> payload) {
        return null;
    }
}