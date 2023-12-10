package com.example.scrum.Repositories;

import com.example.scrum.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepositories extends JpaRepository<Project,Integer> {
}
