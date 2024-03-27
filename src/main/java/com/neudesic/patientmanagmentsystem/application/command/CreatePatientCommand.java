package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.controller.dto.CreatePatientDTO;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CreatePatientCommand extends BaseCommand<CreatePatientDTO>{
    public CreatePatientCommand(UUID id, CreatePatientDTO dto) {
        super(id, dto);
    }
}
