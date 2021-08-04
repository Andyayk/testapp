package com.example.demo.controller;

import com.example.demo.service.PopularJobService;
import com.example.demo.model.PopularJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PopularJobController {

    @Autowired
    private PopularJobService popularJobService;

    @GetMapping("/popularjobs")
    public List<PopularJob> getAllPopularJobs() {
        return popularJobService.findAllPopularJobs();
    }
}
