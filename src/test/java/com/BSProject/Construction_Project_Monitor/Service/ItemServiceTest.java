package com.BSProject.Construction_Project_Monitor.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ItemServiceTest {
    @Autowired
    ItemService itemService;
    @Test
    void testDeleteItemByItemId() {
        	itemService.deleteItemByItemId(3);
    }
}
