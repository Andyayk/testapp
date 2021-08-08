package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.example.demo.model.Job;
import com.example.demo.model.PopularJob;
import com.example.demo.repository.PopularJobRepo;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.lang.Long.parseLong;

@Component
public class ScheduledTasks {

    @Autowired
    private JobService jobService;

    @Autowired
    private PopularJobRepo popularJobRepo;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(cron = "0 55 15 * * *") //every 3:55pm
    public void generateDateTime() {
        /*
            published date 8/8/2021 0:00:00 Singapore Time
            Singapore time now 8/8/2021 8:00:00
            System time now 7/8/2021 23:00:00
        */
        LocalDateTime publishedDate = LocalDateTime.parse("2021-08-08T15:50:00.536");

        LocalDateTime localDateTime = LocalDateTime.now();

        if (publishedDate.isBefore(localDateTime)) {
            System.out.println("YES published, time is " + localDateTime);
        } else {
            System.out.println("NO not published, time is " + localDateTime);
        }
    }

    //@Scheduled(cron = "0 0 2 15 * ?") //second, minute, hour, day, month, weekday, 2am of every 15th of month
    public void generatePopularJobStatistics() {
        //generate most popular job
//        HashMap<Long, Integer> counterMap = new HashMap<>();
//
//        List<Job> jobList = jobService.findAllJobs();
//
//        for (Job job : jobList) {
//            counterMap.put(job.getJobId(), 0);
//        }
//
//        HashMap<String, ArrayList<String>> allUsersFavouritesMap = jobService.findAllUsersFavourites();
//
//        for (String key : allUsersFavouritesMap.keySet()) {
//            ArrayList<String> favouritesList = allUsersFavouritesMap.get(key); //each user favourites list
//
//            for (String favourite : favouritesList) {
//                if (counterMap.containsKey(favourite)) {
//                    int favouriteCount = counterMap.get(favourite); //get previous value
//                    counterMap.put(parseLong(favourite), ++favouriteCount); //update value
//                }
//            }
//        }
//
//        for (Job job : jobList) {
//            Long jobId = job.getJobId();
//            String jobTitle = job.getJobTitle();
//            String jobDescription = job.getJobDescription();
//            String datePosted = job.getDatePosted();
//            int favouriteCount = counterMap.get(jobId);
//            String dateRetrieved = dateFormat.format(new Date());
//
//            PopularJob popularJob = new PopularJob(jobId, jobTitle, jobDescription, datePosted, favouriteCount, dateRetrieved);
//
//            popularJob = popularJobRepo.save(popularJob);
//        }


    }
}