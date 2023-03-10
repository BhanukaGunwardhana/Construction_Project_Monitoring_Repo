package com.BSProject.Construction_Project_Monitor.Entity;

import jakarta.persistence.CascadeType;
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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemUnitPrice;
    private int totalWork;
    private double completedPercentage;
    private int completedWorkDone;
    private int income;

    @ManyToOne(
        cascade = {CascadeType.REFRESH}
    )
    @JoinColumn(
        name = "itemId_projectId",
        referencedColumnName = "projectId"

    )
    private Project project;
}
