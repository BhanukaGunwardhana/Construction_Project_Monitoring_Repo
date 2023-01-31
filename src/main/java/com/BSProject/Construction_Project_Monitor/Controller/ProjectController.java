package com.BSProject.Construction_Project_Monitor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BSProject.Construction_Project_Monitor.DTO.ProjectDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ProjectRetreivingDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Item;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Service.ProjectService;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    
    @RequestMapping("/project")

    @PostMapping("/posting")
    public String postingProject(@RequestBody ProjectDTO projectDTO){
        projectService.postingProject(projectDTO);
        return "Succesfully posted project";
    }

    @GetMapping("/getting/{projectId}")
    public ProjectRetreivingDTO gettingProject(@PathVariable int projectId){

        return projectService.gettingProject(projectId);
    }
    @GetMapping("/gettingprojectresources/{projectId}")
    public List<Resource> getProjectResources(@PathVariable int projectId){
        return projectService.gettingProjectResouces(projectId);
    }
    @GetMapping("/gettingprojectitems/{projectId}")
    public List<Item> getProjectItems(@PathVariable int projectId){
        return projectService.gettingProjectItems(projectId);
    }
    

    
}
