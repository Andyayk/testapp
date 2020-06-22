package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
public class AppUserResource {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/user/{name}")
    public AppUser getUser(@PathVariable String name) {
        return appUserService.findUser(name);
    }
}