package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}