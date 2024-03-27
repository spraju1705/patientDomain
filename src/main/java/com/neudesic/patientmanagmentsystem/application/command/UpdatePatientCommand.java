package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.controller.dto.UpdatePatientDTO;

import java.util.UUID;

public class UpdatePatientCommand extends BaseCommand<UpdatePatientDTO>{
    public UpdatePatientCommand(UUID id, UpdatePatientDTO dto) {
        super(id, dto);
    }
}
