package com.BSProject.Construction_Project_Monitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BSProject.Construction_Project_Monitor.Entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
    
}
