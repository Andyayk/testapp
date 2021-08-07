package com.example.demo.controller;

import com.example.demo.dto.FavouriteJobDTO;
import com.example.demo.model.FavouriteJob;
import com.example.demo.service.JobService;
import com.example.demo.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    //retrieve all jobs
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.findAllJobs();
    }

    //add job
    @PostMapping("/addjob")
    public String addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    //delete job
    @PostMapping("/deletejob")
    public String deleteJob(@RequestBody Job job) {
        return jobService.deleteJob(job);
    }

    //edit job
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
    public List<String> retrieveFavouritesList(@RequestBody HashMap<String, Object> payload) {
        return jobService.findFavouritesList(payload);
    }

    //retrieve a list of favourites jobs of a particular user
    @PostMapping("/retrieveallfavouritesjobs")
    public List<Job> retrieveAllFavouritesJobs(@RequestBody HashMap<String, Object> payload) {
        return jobService.findAllFavouritesJobs(payload);
    }

    //add favourite
    @PostMapping("/favouritejob")
    public String favouriteJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.favouriteJob(favouriteJobDTO);
    }

    //remove favourite
    @PostMapping("/unfavouritejob")
    public String unfavouriteJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.unfavouriteJob(payload);
    }
}
