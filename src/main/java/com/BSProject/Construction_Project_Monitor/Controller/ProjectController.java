package com.BSProject.Construction_Project_Monitor.Controller;

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
    @PutMapping("/putting/{projectId}/{resourceName}")
    public String updateProjectResource(@PathVariable int projectId,@PathVariable String resourceName,@RequestBody ResourceDTO resourceDTO){
        projectService.updateProjectResource(projectId,resourceName,resourceDTO);
        return "resource updated successfully";
    }
    

    
}
