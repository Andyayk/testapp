package com.example.demo;

public class Course {
    private Long id;
    private String username;
    private String description;

    public Course() {
    }

    public Course(Long id, String username, String description) {
        this.id = id;
        this.username = username;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}