package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/loginuser")
    public AppUser loginUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.loginUser(payload.get("username").toString(), payload.get("password").toString());
    }
}
