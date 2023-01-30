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

    

   public String toString(){
        return 
            ("projectId :"+this.projectId+"\n"+
                "projectRetreivingDTO :"+this.pojectRetreivingDTOName+"\n"+
                "projectState :"+this.projectState+"\n"+
                "projectStateAmount :"+this.projectStateAmount
            )
        ;
   }

    
}
