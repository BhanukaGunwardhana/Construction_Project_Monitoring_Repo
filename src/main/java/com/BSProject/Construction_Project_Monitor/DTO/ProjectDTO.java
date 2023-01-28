package com.BSProject.Construction_Project_Monitor.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String projectNameDTO;
    private Date startingDateDTO;
    private int projectDurationDTO;

    
}
