package com.example.scrum.Repositories;

import com.example.scrum.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Integer> {
}
