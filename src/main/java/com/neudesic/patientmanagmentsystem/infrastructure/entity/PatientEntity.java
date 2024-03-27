package com.neudesic.patientmanagmentsystem.infrastructure.entity;


import com.neudesic.patientmanagmentsystem.domain.valueobjects.PatientStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "Patient")
public class PatientEntity {
    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicalConditionEntity> medicalCondition = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PatientStatus patientStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private BioDataEntity bioData;

}
