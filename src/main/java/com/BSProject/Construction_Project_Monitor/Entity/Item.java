package com.BSProject.Construction_Project_Monitor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemUnitPrice;
    private int totatlWork;
    private int completedPercentage;
    private int completedWorkDone;
    private int income;

    @ManyToOne(

    )
    @JoinColumn(
        name = "itemId_projectId",
        referencedColumnName = "projectId"

    )
    private Project project;
}
