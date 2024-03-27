package com.neudesic.patientmanagmentsystem.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
public class PatientID extends BaseID<UUID>{

    public PatientID(UUID id) {
        super(id);
    }

    public PatientID() {
    }
}
