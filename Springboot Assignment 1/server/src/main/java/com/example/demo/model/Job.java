package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "jobId", nullable = false, updatable = false)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;

    @OneToMany(mappedBy = "job")
    Set<FavouriteJob> favouriteJob;
}