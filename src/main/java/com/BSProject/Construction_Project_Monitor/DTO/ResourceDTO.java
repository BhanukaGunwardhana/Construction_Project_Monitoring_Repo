package com.BSProject.Construction_Project_Monitor.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    private String resourceNameDTO;
    private int resourceUnitPriceDTO;
    private int resourceAmountDTO;

    private int projectId;
}
