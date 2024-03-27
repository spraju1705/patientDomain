package com.neudesic.patientmanagmentsystem.infrastructure.repository;

import com.neudesic.patientmanagmentsystem.domain.entities.Patient;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
}
