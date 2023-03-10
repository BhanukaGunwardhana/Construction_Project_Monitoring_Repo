package com.BSProject.Construction_Project_Monitor.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSProject.Construction_Project_Monitor.Entity.Item;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Entity.Resource;
import com.BSProject.Construction_Project_Monitor.Entity.Result;
import com.BSProject.Construction_Project_Monitor.Repository.ProjectRepository;
import com.BSProject.Construction_Project_Monitor.Repository.ResultRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ProjectRepository projectRepository;
    public void postingResult(int projectId){
        Optional<Project> opProject=projectRepository.findById(projectId);
        Project project=opProject.get();
        int income=0;
        int cost=0;
        for (Resource r: project.getResourceList()){
            cost=cost+r.getCost();
        }
        for (Item i: project.getItemList()){
            income=income+i.getIncome();
        }
        String status;
        int dif=income-cost;
        if(dif>0){status="making profits";}
        else if(dif<0){status="making losses";}
        else{status="breakeven";}
        Result result=new Result();
        result.setProject(project);
        result.setResultStatus(status);
        result.setResultStatusAmount(dif);
        result.setCalculated(true);
        
        resultRepository.save(result);
        


    }
    public void calculateAllProjectsStatus(){
        for(Project project: projectRepository.findAll()){
            int income=0;
            int cost=0;
            for (Resource r: project.getResourceList()){
                cost=cost+r.getCost();
            }
            for (Item i: project.getItemList()){
                income=income+i.getIncome();
            }
            String status;
            int dif=income-cost;
            if(dif>0){status="making profits";}
            else if(dif<0){status="making losses";}
            else{status="breakeven";}
            Result result=new Result();
            result.setProject(project);
            result.setResultStatus(status);
            result.setResultStatusAmount(dif);
            result.setCalculated(true);
        
            resultRepository.save(result);
        } 
    }
    public void updateResult(int projectId){
        Optional<Project> opProject=projectRepository.findById(projectId);
        Project project=opProject.get();
        Result result=project.getResult();
        int income=0;
        int cost=0;
        for (Resource r: project.getResourceList()){
            cost=cost+r.getCost();
        }
        for (Item i: project.getItemList()){
            income=income+i.getIncome();
        }
        String status;
        int dif=income-cost;
        if(dif>0){status="making profits";}
        else if(dif<0){status="making losses";}
        else{status="breakeven";}
        
        result.setProject(project);
        result.setResultStatus(status);
        result.setResultStatusAmount(dif);
        result.setCalculated(true);
        
        resultRepository.save(result);
    }
}
