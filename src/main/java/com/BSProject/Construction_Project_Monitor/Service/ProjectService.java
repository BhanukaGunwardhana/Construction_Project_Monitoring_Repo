package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.DTO.ProjectDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ProjectRetreivingDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public void postingProject(ProjectDTO projectDTO){
        Project project=new Project();
        project.setProjectname(projectDTO.getProjectNameDTO());

        projectRepository.save(project);
        
        
    }

    public ProjectRetreivingDTO gettingProject(int projectId){
        ProjectRetreivingDTO projectRetreivingDTO=new ProjectRetreivingDTO();
        Optional<Project> opProject=projectRepository.findById(projectId);
        Project project=opProject.get();
        projectRetreivingDTO.setPojectRetreivingDTOName(project.getProjectname());
        projectRetreivingDTO.setProjectState(project.getResult().getResultState());
        projectRetreivingDTO.setProjectStateAmount(project.getResult().getResultStateAmount());
        projectRetreivingDTO.setProjectId(projectId);

        return projectRetreivingDTO;
    }

    
}
