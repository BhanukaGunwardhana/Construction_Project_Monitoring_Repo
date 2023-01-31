package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResourceRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResultRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ResultService resultService;
    @Autowired
    Mapping mapping;

    public void postingResource(ResourceDTO resourceDTO){
        Resource resource=new Resource();
        resource.setResourceName(resourceDTO.getResourceNameDTO());
       
        Optional<Project> opProject = projectRepository.findById(resourceDTO.getProjectId());
        Project project=opProject.get();
        resource.setProject(project);
        resource.setResourceAmount(resourceDTO.getResourceAmountDTO());
        resource.setResourceUnitPrice(resourceDTO.getResourceUnitPriceDTO());
        resource.setCost(resource.getResourceAmount()*resource.getResourceUnitPrice());

        resourceRepository.save(resource);

    }
    public void updateResourceByResourceId(int resourceId,ResourceDTO resourceDTO){
        Optional<Resource> opResource = resourceRepository.findById(resourceId);
        Resource resource=opResource.get();
        mapping.mapResourceDTOToResource(resourceDTO, resource);
        resourceRepository.save(resource);
        resultService.updateResult(resource.getProject().getProjectId());   
    }
    public void updateResourceAmount(int resourceId,int resourceAmount){
        Optional<Resource> opResource = resourceRepository.findById(resourceId);
        Resource resource=opResource.get();
        resource.setResourceAmount(resourceAmount);
        resourceRepository.save(resource);
        resultService.updateResult(resource.getProject().getProjectId());
    }
    public void deleteResourceByResourceId(int resourceId){
        Optional<Resource> opResource = resourceRepository.findById(resourceId);
        Resource resource=opResource.get();
        Project project=resource.getProject();
        resourceRepository.delete(resource);
        resultService.updateResult(project.getProjectId());
    }
    
}
