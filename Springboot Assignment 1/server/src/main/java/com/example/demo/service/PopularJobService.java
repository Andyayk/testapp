package com.example.demo.service;

import com.example.demo.model.PopularJob;
import com.example.demo.repository.PopularJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularJobService {

    @Autowired
    private PopularJobRepo popularJobRepo;

    public List<PopularJob> findAllPopularJobs() {
        List<PopularJob> popularJobs = popularJobRepo.findAll();

        return popularJobs;
    }
}