package com.neudesic.patientmanagmentsystem.infrastructure.entity;

import com.neudesic.patientmanagmentsystem.domain.valueobjects.Disease;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.MedicalConditionStage;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MedicalCondition")
@Data
public class MedicalConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Disease disease;

    @Enumerated(EnumType.STRING)
    private MedicalConditionStage medicalConditionStage;
}
