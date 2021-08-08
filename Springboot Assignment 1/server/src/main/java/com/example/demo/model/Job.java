package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Job {
    @OneToMany(mappedBy = "job")
    Set<FavouriteJob> favouriteJob;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobId", nullable = false, updatable = false)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;
    @Column(columnDefinition = "varchar(255) default '0'", nullable = false)
    private Integer deleted = 0;
}