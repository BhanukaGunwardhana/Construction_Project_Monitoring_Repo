package com.BSProject.Construction_Project_Monitor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;
    private String resultState;
    private int resultStateAmount;

    @OneToOne(
        
    )
    @JoinColumn(
        name = "resultId_projectId",
        referencedColumnName = "projectId"
    )

    private Project project;
}
