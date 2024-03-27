package com.neudesic.patientmanagmentsystem.controller.dto;

import com.neudesic.patientmanagmentsystem.domain.valueobjects.BioData;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.MedicalCondition;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreatePatientDTO {

    private BioData bioData;

    private List<MedicalCondition> medicalCondition;
}
