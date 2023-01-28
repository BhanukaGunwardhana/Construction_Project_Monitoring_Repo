package com.BSProject.Construction_Project_Monitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BSProject.Construction_Project_Monitor.Entity.Result;

@Repository
public interface ResultRepository extends JpaRepository <Result,Integer>{
    
}
