package com.example.scrum.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String title;
     private String description;
     @JsonIgnore
     @ManyToMany(mappedBy = "projects")
     private Set<User> users;
     @JsonIgnore
     @OneToMany(mappedBy = "project")
     private Set<Sprint>sprints;
}
