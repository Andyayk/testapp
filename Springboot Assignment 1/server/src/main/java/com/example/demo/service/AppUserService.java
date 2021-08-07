package com.example.demo.service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepo;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
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

    //authenticate user
    public AppUser loginUser(String username, String password) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser != null && appUser.getPassword().equals(password) ) { //if user exists and password is correct
            return appUser;
        }
        return null;
    }

    //return all users
    public List<AppUser> findAllUsers() {
        return appUserRepo.findAll();
    }

    //return specific user
    public AppUser findUser(Long employeeId) {
        return appUserRepo.findByEmployeeId(employeeId);
    }


    public String addUser(HashMap<String, Object> payload) {
//        Job job = jobRepo.findByJobId(payload.get("jobId").toString());
//
//        if (job != null) {
//            AppUser appUser = new AppUser(payload.get("jobId").toString(), payload.get("username").toString(), payload.get("password").toString(), payload.get("name").toString(), payload.get("email").toString(), "0", job);
//            appUserRepo.save(appUser);
//            return "Added";
//        } else {
//            return "Error";
//        }
        return "";
    }

    public String deleteUser(HashMap<String, Object> payload) {
        return null;
    }

    public String editUser(HashMap<String, Object> payload) {
        return null;
    }
}