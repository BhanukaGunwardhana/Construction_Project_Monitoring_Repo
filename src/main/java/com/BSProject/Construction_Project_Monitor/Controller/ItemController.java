package com.BSProject.Construction_Project_Monitor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSProject.Construction_Project_Monitor.DTO.ItemDTO;
import com.BSProject.Construction_Project_Monitor.Service.ItemService;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    @RequestMapping("/item")
    @PostMapping("/posting")
    public String postingItem(@RequestBody ItemDTO itemDTO){
        itemService.postingItem(itemDTO);
        return "item posted successfully";
    }
    @PutMapping("/updating/{itemId}")
    public String updateItem(@PathVariable int itemId,@RequestBody ItemDTO itemDTO){
        itemService.updateItemByItemId(itemDTO, itemId);
        return "item updated successfully";
    }

}
