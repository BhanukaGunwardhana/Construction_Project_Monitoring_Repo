package com.BSProject.Construction_Project_Monitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSProject.Construction_Project_Monitor.Entity.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    
}
