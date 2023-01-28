package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.DTO.ItemDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Item;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Repository.ItemRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProjectRepository projectRepository;
    public void postingItem(ItemDTO itemDTO){
        Item item=new Item();
        item.setItemName(itemDTO.getItemNameDTO());
        Optional<Project> projectOptional=projectRepository.findById(itemDTO.getProjectId());
        Project project=projectOptional.get();
        item.setProject(project);
        item.setTotatlWork(itemDTO.getItemTotalWorkDTO());
        item.setCompletedPercentage(itemDTO.getItemCompletedPercentageDTO());
        item.setCompletedWorkDone((int) (item.getTotatlWork()*item.getCompletedPercentage()));
        item.setItemUnitPrice(itemDTO.getItemUnitPriceDTO());
        item.setIncome(item.getCompletedWorkDone()*item.getItemUnitPrice());
    

        itemRepository.save(item);
        
    }
    
}
