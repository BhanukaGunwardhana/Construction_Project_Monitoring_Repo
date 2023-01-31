package com.BSProject.Construction_Project_Monitor.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BSProject.Construction_Project_Monitor.DTO.ItemDTO;
import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Service.ResourceService;

@SpringBootTest
public class ResourceRepositoryTest {
    @Autowired
    ResourceService resourceService;
    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void testPostingResource(){
        ResourceDTO resourceDTO=ResourceDTO.builder()
        .projectId(1)
        .resourceAmountDTO(10)
        .resourceNameDTO("labour")
        .resourceUnitPriceDTO(1000)
        .build();
       
        resourceService.postingResource(resourceDTO);
    }

    @Test
    public void testupdateResourceByResourceId(){
        ResourceDTO resourceDTO=ResourceDTO.builder()
        .resourceNameDTO("updatedResourceName2")
        .build();

        resourceService.updateResourceByResourceId(1, resourceDTO);
        
    }
}
