package com.BSProject.Construction_Project_Monitor.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BSProject.Construction_Project_Monitor.DTO.ProjectRetreivingDTO;
import com.BSProject.Construction_Project_Monitor.Entity.Project;
import com.BSProject.Construction_Project_Monitor.Service.ProjectService;

@SpringBootTest
public class ProjectRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectService projectService;

    @Test
    public void testpostingProject(){
        Project project=Project.builder()
        .projectname("A")
        .build();

        projectRepository.save(project);
    }

    @Test
    public void testgettingProject(){
        ProjectRetreivingDTO prDTO = projectService.gettingProject(1);
        System.out.println(prDTO.toString());
    } 
}
