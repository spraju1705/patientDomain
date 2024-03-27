package com.neudesic.patientmanagmentsystem.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Biodata")
public class BioDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    private String address;
}
