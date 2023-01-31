package com.BSProject.Construction_Project_Monitor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSProject.Construction_Project_Monitor.Service.ResultService;

@RestController
public class ResultController {
    @Autowired
    ResultService resultService;
    @RequestMapping("/result")
    @PostMapping("/postingresult/{projectId}")
    public String postingresult(@PathVariable int projectId){
        resultService.postingResult(projectId);
        return "result posted successfully";
    }
    @PostMapping("/calculatingresults")
    public String postingResults(){
        resultService.calculateAllProjectsStatus();
        return "Financial state have been calulated";
        
    }
    @PutMapping("/updateResult/{projectId}")
    public String updateResult(@PathVariable int projectid){
        resultService.updateResult(projectid);
        return "result updated successfully";
    }
}
