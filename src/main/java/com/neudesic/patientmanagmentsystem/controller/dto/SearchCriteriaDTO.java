package com.neudesic.patientmanagmentsystem.controller.dto;

import com.neudesic.patientmanagmentsystem.application.query.DobSearchAccuracy;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.Disease;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class SearchCriteriaDTO {
    private String name;
    private LocalDate dob;
    private DobSearchAccuracy dobSearchAccuracy;
    private Disease disease;
}
