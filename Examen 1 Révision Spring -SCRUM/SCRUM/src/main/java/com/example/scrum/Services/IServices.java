package com.example.scrum.Services;

import com.example.scrum.Entities.Project;
import com.example.scrum.Entities.User;

import java.util.Date;
import java.util.List;

public interface IServices {
    public void addUser (User user);
    public void addProject (Project project);
    public void assignProjectToUser(int projectId, int userId);
    public List<Project> getAllProjects();
    public List<Project> getProjectsByUser(int userId);
    public void addSprintAndAssignToProject(String description, Date startDate, int idProject);
}
