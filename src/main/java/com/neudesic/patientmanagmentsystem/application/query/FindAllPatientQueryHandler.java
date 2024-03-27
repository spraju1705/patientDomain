package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;
import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllPatientQueryHandler implements QueryHandlerMethod{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<? extends Entity> handle(BaseQuery query) {
        var patientEntities = patientRepository.findAll();
        var patients =  patientEntities.stream().map(x-> modelMapper.map(x, Patient.class)).collect(Collectors.toList());
        return patients;
    }
}
