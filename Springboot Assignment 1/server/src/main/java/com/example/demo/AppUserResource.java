package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class AppUserResource {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/user/{username}")
    public AppUser getUser(@PathVariable String username) {
        return appUserService.findUser(username);
    }

    @PostMapping("/loginuser")
    public AppUser loginUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.loginUser(payload);
    }
}