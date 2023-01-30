package com.BSProject.Construction_Project_Monitor.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.DTO.ProjectDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ProjectRetreivingDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Item;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResourceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ResultService resultService;
    @Autowired
    ResourceService resourceService;
    public void postingProject(ProjectDTO projectDTO){
        Project project=new Project();
        project.setProjectname(projectDTO.getProjectNameDTO());

        projectRepository.save(project);
        
        
    }

    public ProjectRetreivingDTO gettingProject(int projectId){
        
        ProjectRetreivingDTO projectRetreivingDTO=new ProjectRetreivingDTO();
        Optional<Project> opProject=projectRepository.findById(projectId);
        Project project=opProject.get();
        if(!project.getResult().isCalculated()){
            resultService.postingResult(projectId);
        }
        projectRetreivingDTO.setPojectRetreivingDTOName(project.getProjectname());
        projectRetreivingDTO.setProjectState(project.getResult().getResultStatus());
        projectRetreivingDTO.setProjectStateAmount(project.getResult().getResultStatusAmount());
        projectRetreivingDTO.setProjectId(projectId);

        return projectRetreivingDTO;
    }

    public List<Resource> gettingProjectResouces(int projectId){
        Optional<Project> opProject = projectRepository.findById(projectId);
        Project project=opProject.get();
        return project.getResourceList();
        
    }
    public List<Item> gettingProjectItems(int projectId){
        Optional<Project> opProject = projectRepository.findById(projectId);
        Project project=opProject.get();
        return project.getItemList();
        
    }

    public void updateProjectResource(int projectId, String resourceName,ResourceDTO resourceDTO) {
        Optional<Project> opProject = projectRepository.findById(projectId);
        Project project=opProject.get();
        for (Resource resource:project.getResourceList() ){
            if(resource.getResourceName().equalsIgnoreCase(resourceName)){
                resource.setResourceName(resourceDTO.getResourceNameDTO());
                Optional<Project> opProject_ = projectRepository.findById(resourceDTO.getProjectId());
                Project project_=opProject_.get();
                resource.setProject(project_);
                resource.setResourceAmount(resourceDTO.getResourceAmountDTO());
                resource.setResourceUnitPrice(resourceDTO.getResourceUnitPriceDTO());
                resource.setCost(resource.getResourceAmount()*resource.getResourceUnitPrice());

                resourceRepository.save(resource);

                
            }
        }


    }


    
}
