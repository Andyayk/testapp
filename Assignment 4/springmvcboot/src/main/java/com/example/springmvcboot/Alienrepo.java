package com.example.springmvcboot;

import com.example.springmvcboot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Alienrepo extends JpaRepository<Alien, Integer> {
}
