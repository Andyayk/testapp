package com.example.demo.repository;

import com.example.demo.model.FavouriteJob;
import com.example.demo.model.FavouriteJobKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FavouriteJobRepo extends JpaRepository<FavouriteJob, FavouriteJobKey> {
    List<FavouriteJob> findAllByIdEmployeeId(Long employeeId);
}
