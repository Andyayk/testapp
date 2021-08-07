package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "employeeId", nullable = false, updatable = false)
    private Long employeeId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String isadmin;

    @OneToMany(mappedBy = "appUser")
    Set<FavouriteJob> favouriteJob;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    public Set<FavouriteJob> getFavouriteJob() {
        return favouriteJob;
    }

    public void setFavouriteJob(Set<FavouriteJob> favouriteJob) {
        this.favouriteJob = favouriteJob;
    }
}
