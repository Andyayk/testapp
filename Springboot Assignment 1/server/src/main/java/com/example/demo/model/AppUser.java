package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
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
}
