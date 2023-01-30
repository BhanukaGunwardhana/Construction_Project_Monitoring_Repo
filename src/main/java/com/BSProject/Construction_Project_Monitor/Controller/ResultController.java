package com.BSProject.Construction_Project_Monitor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSProject.Construction_Project_Monitor.Service.ResultService;

@RestController
public class ResultController {
    @Autowired
    ResultService resultService;
    @RequestMapping("/result")
    @PostMapping("/posting")
    public String postingResult(){
        resultService.calculateAllProjectsStatus();
        return "Financial state have been calulated";
        
    }
}
