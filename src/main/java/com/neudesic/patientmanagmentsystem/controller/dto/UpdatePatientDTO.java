package com.neudesic.patientmanagmentsystem.controller.dto;

import com.neudesic.patientmanagmentsystem.domain.valueobjects.BioData;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.MedicalCondition;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdatePatientDTO {

    private BioData bioData;

    private List<MedicalCondition> medicalCondition;
}
