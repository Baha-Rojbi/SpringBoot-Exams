package com.example.scrum.Repositories;

import com.example.scrum.Entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepositories extends JpaRepository<Sprint,Integer> {
}
