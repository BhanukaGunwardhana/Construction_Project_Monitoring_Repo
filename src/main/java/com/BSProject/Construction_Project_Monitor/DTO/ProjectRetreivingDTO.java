package com.BSProject.Construction_Project_Monitor.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRetreivingDTO {
    private int projectId;
    private String pojectRetreivingDTOName;
    private String projectState;
    private int projectStateAmount;
    
}
