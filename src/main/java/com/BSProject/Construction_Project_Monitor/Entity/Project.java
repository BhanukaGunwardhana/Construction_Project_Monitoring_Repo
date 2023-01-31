package com.BSProject.Construction_Project_Monitor.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProjectId;
    private String projectname;
    private Date remainingDays;

    @OneToMany(
        mappedBy = "project",
        cascade = CascadeType.REMOVE
    )

    private List<Item> itemList;

    @OneToMany(
        mappedBy = "project",
        cascade = {CascadeType.REMOVE,CascadeType.REFRESH}
    )

    private List<Resource> resourceList;

    @OneToOne(
        mappedBy = "project",
        cascade = {CascadeType.REMOVE,CascadeType.REFRESH}
    )

    private Result result;
   
}
