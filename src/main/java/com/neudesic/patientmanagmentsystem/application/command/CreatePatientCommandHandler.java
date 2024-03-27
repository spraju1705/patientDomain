package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.domain.event.PatientCreateEvent;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.PatientID;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.PatientEntity;
import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePatientCommandHandler implements CommandHandlerMethod<CreatePatientCommand> {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public UpdateCommandResponse handle(CreatePatientCommand command) {
        var patient =Patient.Builder.newPatient().withId(new PatientID(command.getId())).withBioData(command.getDto().getBioData())
                        .withMedicalCondition(command.getDto().getMedicalCondition()).build();
        patient.apply(new PatientCreateEvent());
        var createdPatient = patientRepository.save(modelMapper.map(patient, PatientEntity.class));
        return UpdateCommandResponse.builder().id(createdPatient.getId()).message("Patient ID: "+ createdPatient.getId()+" created successfully").build();

    }
}
