package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePatientCommandHandler implements CommandHandlerMethod<UpdatePatientCommand>{

    @Autowired
    PatientRepository patientRepository;
    @Override
    public UpdateCommandResponse handle(UpdatePatientCommand command) {
        var patientEntity = patientRepository.findById(command.getId());
        if (patientEntity.isPresent()){
            patientEntity.get().getBioData().setAddress(command.getDto().getBioData().getAddress());
            patientEntity.get().getBioData().setName(command.getDto().getBioData().getName());
            patientEntity.get().getBioData().setDateOfBirth(command.getDto().getBioData().getDateOfBirth());
            patientRepository.flush();
        }

        return UpdateCommandResponse.builder().id(command.getId()).message("Successfully updated").build();

    }
}
