package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private static List<AppUser> users = new ArrayList<>();
    private static int employeeidCounter = 0;

    static {
        users.add(new AppUser("user1", "user1@gmail.com" , Integer.toString(++employeeidCounter), true));
        users.add(new AppUser("user2", "user2@gmail.com" , Integer.toString(++employeeidCounter), false));
        users.add(new AppUser("user3", "user3@gmail.com" , Integer.toString(++employeeidCounter), true));
        users.add(new AppUser("user4", "user4@gmail.com" , Integer.toString(++employeeidCounter), false));
    }

    public AppUser findUser(String name) {
        AppUser user = null;
        for(int i=0; i<users.size(); i++){
            AppUser eachUser = users.get(i);
            if(eachUser.getName().equalsIgnoreCase(name)){
                user = eachUser;
            }
        }
        return user;
    }
}