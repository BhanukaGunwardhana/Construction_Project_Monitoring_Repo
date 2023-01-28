package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResourceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void postingResource(ResourceDTO resourceDTO){
        Resource resource=new Resource();
        resource.setResourceName(resourceDTO.getResourceNameDTO());
        Project project = new Project();
        Optional<Project> opProject = projectRepository.findById(resourceDTO.getProjectId());
        project=opProject.get();
        resource.setProject(project);
        resource.setResourceAmount(resourceDTO.getResourceAmountDTO());
        resource.setResourceUnitPrice(resourceDTO.getResourceUnitPriceDTO());
        resource.setCost(resource.getResourceAmount()*resource.getResourceUnitPrice());

        resourceRepository.save(resource);

    }
    
}
