package com.example.demo.dto;

import com.example.demo.model.Job;
import lombok.Data;

@Data
public class AppUserDTO {
    private String employeeId;
    private String name;
    private String email;
    private String isadmin;
}
