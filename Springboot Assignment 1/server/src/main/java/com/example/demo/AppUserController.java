package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/loginuser")
    public AppUser loginUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.loginUser(payload.get("username").toString(), payload.get("password").toString());
    }

    //retrieve all users
    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return appUserService.findAllUsers();
    }

    //retrieve user
    @PostMapping("/user")
    public AppUser getUser(@RequestBody HashMap<String, Object> payload) {
        System.out.println(payload);
        return appUserService.findUser(payload.get("employeeid").toString());
    }

    //add user
    @PostMapping("/adduser")
    public String addUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.addUser(payload);
    }

    //delete user
    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestBody HashMap<String, Object> payload) { return appUserService.deleteUser(payload); }

    //edit user
    @PutMapping("/edituser")
    public String editUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.editUser(payload);
    }
}
