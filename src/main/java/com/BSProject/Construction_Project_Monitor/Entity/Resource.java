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
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;
    private String resourceName;
    private int resourceUnitPrice;
    private int resourceAmount;
    private int cost;

    @ManyToOne(

    )
    @JoinColumn(
        name = "resourceId_projectId",
        referencedColumnName = "projectId"
    )
    private Project project;

}
