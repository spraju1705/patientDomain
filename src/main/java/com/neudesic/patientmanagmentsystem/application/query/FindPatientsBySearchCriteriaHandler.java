package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;
import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.infrastructure.repository.PatientCustomSearchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindPatientsBySearchCriteriaHandler implements QueryHandlerMethod<FindPatientsBySearchCriteriaQuery>{

    @Autowired
    PatientCustomSearchRepository patientCustomSearchRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<? extends Entity> handle(FindPatientsBySearchCriteriaQuery query) {
        var patientsFromDB = patientCustomSearchRepository.findPatients(query);
        var patients = patientsFromDB.stream().map(x-> modelMapper.map(x, Patient.class)).collect(Collectors.toList());
        return patients;
    }
}
