package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

    AppUser findByEmployeeid(String employeeid);
}
