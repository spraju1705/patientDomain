package com.neudesic.patientmanagmentsystem.infrastructure.configuration;

import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.PatientID;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.MedicalConditionEntity;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.PatientEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Patient, PatientEntity>() {
            @Override
            protected void configure() {
                map().setId(source.getId().id); // Map name property directly
            }
        });

        modelMapper.addMappings(new PropertyMap<PatientEntity, Patient>() {
            @Override
            protected void configure() {
                map().setId(new PatientID(source.getId())); // Map name property directly
            }
        });

        return modelMapper;
    }
}


