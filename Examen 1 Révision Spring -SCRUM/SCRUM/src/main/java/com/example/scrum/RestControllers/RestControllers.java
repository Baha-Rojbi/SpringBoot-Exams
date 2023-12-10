package com.example.scrum.RestControllers;

import com.example.scrum.Entities.Project;
import com.example.scrum.Entities.User;
import com.example.scrum.Services.IServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestControllers {
    private IServices iServices;
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
iServices.addUser(user);
    }
    @PostMapping("/addProject")
    public void addProject (@RequestBody Project project){
        iServices.addProject(project);
    }
    @PostMapping("/assignProjectToUser/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable int projectId,@PathVariable int userId){
        iServices.assignProjectToUser(projectId,userId);
    }
    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects(){
        return iServices.getAllProjects();
    }
    @GetMapping("/getProjectsByUser/{userId}")
    public List<Project> getProjectsByUser(@PathVariable int userId){
        return iServices.getProjectsByUser(userId);
    }
    @PostMapping("/addSprintAndAssignToProject/{description}/{startDate}/{idProject}")
    public void addSprintAndAssignToProject(@PathVariable String description,@PathVariable Date startDate,@PathVariable int idProject){
        iServices.addSprintAndAssignToProject(description,startDate,idProject);
    }
}
