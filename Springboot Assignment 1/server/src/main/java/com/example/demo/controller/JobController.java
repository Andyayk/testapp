package com.example.demo.controller;

import com.example.demo.dto.FavouriteJobDTO;
import com.example.demo.dto.JobDTO;
import com.example.demo.service.JobService;
import com.example.demo.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    //retrieve all jobs from database
    @GetMapping("/jobs")
    public List<JobDTO> getAllJobs() {
        return jobService.findAllJobs();
    }

    //add job into database
    @PostMapping("/addjob")
    public String addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    //delete job from database
    @PostMapping("/deletejob")
    public String deleteJob(@RequestBody Job job) {
        return jobService.deleteJob(job);
    }

    //edit job in database
    @PostMapping("/editjob")
    public String editJob(@RequestBody Job job) {
        return jobService.editJob(job);
    }

    //retrieve all favourites regardless of user
    @GetMapping("/favourites")
    public HashMap<String, ArrayList<String>> getAllUsersFavourites() {
        return jobService.findAllUsersFavourites();
    }

    //retrieve a list containing favourites job ID of a particular user
    @PostMapping("/retrievefavouriteslist")
    public List<Long> retrieveFavouritesList(@RequestBody HashMap<String, Object> payload) {
        return jobService.findFavouritesList(payload);
    }

    //retrieve a list of favourites jobs of a particular user
    @PostMapping("/retrieveallfavouritesjobs")
    public List<FavouriteJobDTO> retrieveAllFavouritesJobs(@RequestBody HashMap<String, Object> payload) {
        return jobService.findAllFavouritesJobs(payload);
    }

    //add a favourite by user in database
    @PostMapping("/favouritejob")
    public String favouriteJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.favouriteJob(payload);
    }

    //remove a favourite by user in database
    @PostMapping("/unfavouritejob")
    public String unfavouriteJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.unfavouriteJob(payload);
    }
}
