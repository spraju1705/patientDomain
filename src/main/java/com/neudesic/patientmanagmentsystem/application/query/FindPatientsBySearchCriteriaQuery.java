package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.valueobjects.Disease;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.MedicalConditionStage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class FindPatientsBySearchCriteriaQuery extends BaseQuery{
    private String name;
    private LocalDate dob;
    private DobSearchAccuracy dobSearchAccuracy;
    private Disease disease;

}
