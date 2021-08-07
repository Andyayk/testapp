package com.example.demo.repository;

import com.example.demo.model.FavouriteJob;
import com.example.demo.model.FavouriteJobKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FavouriteJobRepo extends JpaRepository<FavouriteJob, FavouriteJobKey> {
    void delete(Optional<FavouriteJob> favouriteJob);

//    FavouriteJob findByIdEmployeeIdAndJobId(Long employeeId, Long jobId);
}
