package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private static List<AppUser> users = new ArrayList<>();
    private static int employeeidCounter = 0;

    static {
        users.add(new AppUser(Integer.toString(++employeeidCounter), "admin1", "1234", "administrator 1", "admin1@gmail.com" ,  true));
        users.add(new AppUser(Integer.toString(++employeeidCounter), "admin2", "1234", "administrator 2", "admin2@gmail.com" ,  true));
        users.add(new AppUser(Integer.toString(++employeeidCounter), "user1", "1234", "user 1", "user1@gmail.com" ,  false));
        users.add(new AppUser(Integer.toString(++employeeidCounter), "user2", "1234", "user 2", "user2@gmail.com" ,  false));
    }

    public AppUser findUser(String username) {
        AppUser user = null;
        for(int i=0; i<users.size(); i++){
            AppUser eachUser = users.get(i);
            if(eachUser.getUsername().equalsIgnoreCase(username)){
                user = eachUser;
            }
        }
        return user;
    }
}