package com.BSProject.Construction_Project_Monitor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSProject.Construction_Project_Monitor.DTO.ResourceDTO;
import com.BSProject.Construction_Project_Monitor.Service.ResourceService;

@RestController
public class ResourceController {
    @Autowired 
    ResourceService resourceService;
    @RequestMapping("/Resource")
    @PostMapping("/posting")
    public String postingResource(@RequestBody ResourceDTO resourceDTO){
        resourceService.postingResource(resourceDTO);
        return "resource posted successfully";
    }
}
