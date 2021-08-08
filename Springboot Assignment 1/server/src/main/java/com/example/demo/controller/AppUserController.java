package com.example.demo.controller;

import com.example.demo.dto.AppUserDTO;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    //check user credentials
    @PostMapping("/loginuser")
    public AppUserDTO loginUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.loginUser(payload.get("username").toString(), payload.get("password").toString());
    }

    //retrieve all users
    @GetMapping("/users")
    public List<AppUserDTO> getAllUsers() {
        return appUserService.findAllUsers();
    }

    //retrieve user from database
    @PostMapping("/user")
    public AppUserDTO getUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.findUser((Long) (payload.get("employeeId"))); //convert to long and retrieve user
    }

    //add user to database
    @PostMapping("/adduser")
    public String addUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.addUser(payload);
    }

    //delete user from database
    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.deleteUser(payload);
    }

    //edit user in database
    @PutMapping("/edituser")
    public String editUser(@RequestBody HashMap<String, Object> payload) {
        return appUserService.editUser(payload);
    }
}
