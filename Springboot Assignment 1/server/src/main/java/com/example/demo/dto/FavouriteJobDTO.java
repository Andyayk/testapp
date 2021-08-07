package com.example.demo.dto;

import com.example.demo.model.FavouriteJobKey;
import lombok.Data;

@Data
public class FavouriteJobDTO {
    private FavouriteJobKey id;
    private JobDTO job;
}
