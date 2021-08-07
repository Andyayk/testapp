package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PopularJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;
    private int favouriteCount;
    private String dateRetrieved;

    public PopularJob() {
    }

    public PopularJob(Long jobId, String jobTitle, String jobDescription, String datePosted, int favouriteCount, String dateRetrieved) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.datePosted = datePosted;
        this.favouriteCount = favouriteCount;
        this.dateRetrieved = dateRetrieved;
    }
}
