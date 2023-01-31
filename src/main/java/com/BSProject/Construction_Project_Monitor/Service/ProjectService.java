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
import com.BSProject.Construction_Project_Monitor.Entity.Result;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResourceRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResultRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ResultRepository resultRepository;
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
        /*if(project.getResult()==null){
            resultService.postingResult(projectId);
        }*
        /*if(!project.getResult().isCalculated()){
            resultService.postingResult(projectId);
            project.getResult().setCalculated(true);
        }*/
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
    public void deleteProjectByProjectId(int projectId){
        Optional<Project> opProject = projectRepository.findById(projectId);
        Project project=opProject.get();
        projectRepository.delete(project);
    }
    /* 
    public void updateProjectResource(int projectId, String resourceName,ResourceDTO resourceDTO) {
        Optional<Project> opProject = projectRepository.findById(projectId);
        Project project=opProject.get();
        Project project_=null;
        for (Resource resource:project.getResourceList() ){
            if(resource.getResourceName().equalsIgnoreCase(resourceName)){
                if(resourceDTO.getResourceNameDTO()!=null){
                    resource.setResourceName(resourceDTO.getResourceNameDTO());
                }
                if(resourceDTO.getProjectId()!=0){
                    Optional<Project> opProject_ = projectRepository.findById(resourceDTO.getProjectId());
                    project_=opProject_.get();
                    resource.setProject(project_);
                }
                if(resourceDTO.getResourceAmountDTO()!=0){
                    resource.setResourceAmount(resourceDTO.getResourceAmountDTO());
                }
                if(resourceDTO.getResourceUnitPriceDTO()!=0){
                    resource.setResourceUnitPrice(resourceDTO.getResourceUnitPriceDTO());
                }
                if(resourceDTO.getResourceAmountDTO()!=0 || resourceDTO.getResourceUnitPriceDTO()!=0){
                    resource.setCost(resource.getResourceAmount()*resource.getResourceUnitPrice());
                }
                resourceRepository.save(resource);

                
            }
        }
        resultService.postingResult(projectId);
        if(project_!=null){
            resultService.postingResult(projectId);
        }



    }*/


    
}
