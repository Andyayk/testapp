package com.example.demo.repository;

import com.example.demo.model.FavouriteJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteJobRepo extends JpaRepository<FavouriteJob, String> {


}
