package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePatientCommandHandler implements CommandHandlerMethod<DeletePatientCommand>{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public UpdateCommandResponse handle(DeletePatientCommand command) {
        patientRepository.deleteById(command.getId());
        return UpdateCommandResponse.builder().id(command.getId()).message("Successfully deleted").build();
    }
}
