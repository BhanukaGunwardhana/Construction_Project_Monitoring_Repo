package com.BSProject.Construction_Project_Monitor.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String itemNameDTO;
    private int itemUnitPriceDTO;
    private int itemTotalWorkDTO;
    private double itemCompletedPercentageDTO;

    private int projectId;
}
