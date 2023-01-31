package com.BSProject.Construction_Project_Monitor.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BSProject.Construction_Project_Monitor.Service.Mapping;

@Configuration
public class ProjectConfiguration {
    @Bean
    public Mapping mapping(){
        return new Mapping();
    }
    
}
