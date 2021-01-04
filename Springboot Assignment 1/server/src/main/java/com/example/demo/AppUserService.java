package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

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

    public AppUser findUser(String employeeid) {
        return appUserRepo.findByEmployeeid(employeeid);
    }

    public String addUser(HashMap<String, Object> payload) {
        return null;
    }

    public String deleteUser(HashMap<String, Object> payload) {
        return null;
    }

    public String editUser(HashMap<String, Object> payload) {
        return null;
    }
}