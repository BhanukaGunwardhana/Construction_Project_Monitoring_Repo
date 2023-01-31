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
    @Autowired
    Mapping mapping;
    @Autowired
    ResultService resultService;
    public void postingItem(ItemDTO itemDTO){
        Item item=new Item();
        item.setItemName(itemDTO.getItemNameDTO());
        Optional<Project> projectOptional=projectRepository.findById(itemDTO.getProjectId());
        Project project=projectOptional.get();
        item.setProject(project);
        item.setTotalWork(itemDTO.getItemTotalWorkDTO());
        item.setCompletedPercentage(itemDTO.getItemCompletedPercentageDTO());
        item.setCompletedWorkDone((int) (item.getTotalWork()*item.getCompletedPercentage()));
        item.setItemUnitPrice(itemDTO.getItemUnitPriceDTO());
        item.setIncome(item.getCompletedWorkDone()*item.getItemUnitPrice());
    

        itemRepository.save(item);
        
    }
    public void updateItemByItemId(ItemDTO itemDTO,int itemId){
        Optional<Item> opItem = itemRepository.findById(itemId);
        Item item=opItem.get();
        mapping.mapItemDTOtoItem(itemDTO, item);
        itemRepository.save(item);
        resultService.updateResult(item.getProject().getProjectId());

    }

    public void updateItemCompletedPercentage(int itemId,double completedPercentage){
        Optional<Item> opItem = itemRepository.findById(itemId);
        Item item=opItem.get();
        item.setCompletedPercentage(completedPercentage);
        item.setCompletedWorkDone((int) (item.getTotalWork()*item.getCompletedPercentage()));
        item.setIncome(item.getCompletedWorkDone()*item.getItemUnitPrice());
        itemRepository.save(item);
        resultService.updateResult(item.getProject().getProjectId());
    }
    public void deleteItemByItemId(int itemId){
        Optional<Item> opItem = itemRepository.findById(itemId);
        Item item=opItem.get();
        Project project=item.getProject();
        itemRepository.delete(item);
        
        resultService.updateResult(project.getProjectId());
    }


    
    
}
