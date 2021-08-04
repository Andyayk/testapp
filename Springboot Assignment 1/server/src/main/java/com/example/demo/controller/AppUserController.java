package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.dto.AppUserDTO;
import com.example.demo.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

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
    public AppUserDTO getUser(@RequestBody HashMap<String, Object> payload) {
        AppUser appUser = appUserService.findUser(payload.get("jobId").toString());
        AppUserDTO userDTO = modelMapper.map(appUser, AppUserDTO.class);
        return userDTO;
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
