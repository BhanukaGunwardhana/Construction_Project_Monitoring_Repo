package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BSProject.Construction_Project_Monitor.DTO.ItemDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Item;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;

public class Mapping {
    @Autowired
    ProjectRepository projectRepository;
    public void mapResourceDTOToResource(ResourceDTO resourceDTO,Resource resource){
        if(resourceDTO.getResourceNameDTO()!=null){
            resource.setResourceName(resourceDTO.getResourceNameDTO());
        }
        if(resourceDTO.getProjectId()!=0){
            Optional<Project> opProject_ = projectRepository.findById(resourceDTO.getProjectId());
            Project project_=opProject_.get();
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
        
    }
    public void mapItemDTOtoItem(ItemDTO itemDTO,Item item){
        if(!itemDTO.getItemNameDTO().equals(null)){
            item.setItemName(itemDTO.getItemNameDTO());
        }
        if(itemDTO.getItemCompletedPercentageDTO()!=0){
            item.setCompletedPercentage(itemDTO.getItemCompletedPercentageDTO());
        }
        if(itemDTO.getItemTotalWorkDTO()!=0){
            item.setTotalWork(itemDTO.getItemTotalWorkDTO());
        }
        if(itemDTO.getItemUnitPriceDTO()!=0){
            item.setItemUnitPrice(itemDTO.getItemUnitPriceDTO());
        }
        if(itemDTO.getProjectId()!=0){
            Optional<Project> opProject=projectRepository.findById(itemDTO.getProjectId());
            Project project=opProject.get();
            item.setProject(project);
        }
        if(itemDTO.getItemCompletedPercentageDTO()!=0 || itemDTO.getItemTotalWorkDTO()!=0 ){
            item.setCompletedWorkDone((int) (item.getTotalWork()*item.getCompletedPercentage()));
        }
        if(itemDTO.getItemCompletedPercentageDTO()!=0 || itemDTO.getItemTotalWorkDTO()!=0 || itemDTO.getItemUnitPriceDTO()!=0){
            item.setIncome(item.getCompletedWorkDone()*item.getItemUnitPrice());
        }
    }
}
