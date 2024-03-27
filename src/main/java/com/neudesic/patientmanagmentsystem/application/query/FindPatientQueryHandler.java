package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;
import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindPatientQueryHandler implements QueryHandlerMethod{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<? extends Entity> handle(BaseQuery query) {
        var patientEntity = patientRepository.findById(((FindPatientQuery)query).getId());
        var patient =  modelMapper.map(patientEntity.get(), Patient.class);
        return List.of(patient);
    }
}