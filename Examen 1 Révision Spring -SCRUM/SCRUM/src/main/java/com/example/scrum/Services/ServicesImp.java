package com.example.scrum.Services;

import com.example.scrum.Entities.Project;
import com.example.scrum.Entities.Sprint;
import com.example.scrum.Entities.User;
import com.example.scrum.Repositories.ProjectRepositories;
import com.example.scrum.Repositories.SprintRepositories;
import com.example.scrum.Repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicesImp implements IServices {
    private ProjectRepositories projectRepositories;
    private SprintRepositories sprintRepositories;
    private UserRepositories userRepositories;

    @Override
    public void addUser(User user) {
        userRepositories.save(user);
    }

    @Override
    public void addProject(Project project) {
        projectRepositories.save(project);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project=projectRepositories.findById(projectId).orElse(null);
        User user=userRepositories.findById(userId).orElse(null);
        user.getProjects().add(project);
        userRepositories.save(user);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepositories.findAll();
    }

    @Override
    public List<Project> getProjectsByUser(int userId) {
        User user=userRepositories.findById(userId).orElse(null);

        return user.getProjects().stream().toList();
    }

    @Override
    public void addSprintAndAssignToProject(String description, Date startDate, int idProject) {
        Project project=projectRepositories.findById(idProject).orElse(null);
        Sprint sprint=new Sprint();
        sprint.setDescription(description);
        sprint.setStartDate(startDate);
        sprint.setProject(project);
        sprintRepositories.save(sprint);
    }
}
