package com.BSProject.Construction_Project_Monitor.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BSProject.Construction_Project_Monitor.Service.ResultService;

@SpringBootTest
public class ResultRepositoryTest {
    @Autowired
    ResultService resultService;
    @Test
    public void testPostingResult(){
        resultService.postingResult(1);
    }

    @Test
    public void testUpdateResult(){
        resultService.updateResult(1);
    }
    
}
