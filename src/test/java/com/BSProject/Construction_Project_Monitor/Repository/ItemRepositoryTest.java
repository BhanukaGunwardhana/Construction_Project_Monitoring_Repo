package com.BSProject.Construction_Project_Monitor.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BSProject.Construction_Project_Monitor.DTO.ItemDTO;
import com.BSProject.Construction_Project_Monitor.Service.ItemService;

@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;
    @Test
    public void testpostingItem(){
        ItemDTO itemDTO=ItemDTO.builder()
        .itemCompletedPercentageDTO(0.1)
        .itemTotalWorkDTO(10000)
        .itemNameDTO("siteClearing")
        .itemUnitPriceDTO(50)
        .projectId(1)
        .build();

        itemService.postingItem(itemDTO);
    }

}
