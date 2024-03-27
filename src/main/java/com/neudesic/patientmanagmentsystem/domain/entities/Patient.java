package com.neudesic.patientmanagmentsystem.domain.entities;

import com.neudesic.patientmanagmentsystem.domain.event.PatientCreateEvent;
import com.neudesic.patientmanagmentsystem.domain.event.PatientDeleteEvent;
import com.neudesic.patientmanagmentsystem.domain.event.PatientDomainEvent;
import com.neudesic.patientmanagmentsystem.domain.event.PatientUpdateEvent;
import com.neudesic.patientmanagmentsystem.domain.exceptions.PatientDomainException;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.BioData;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.MedicalCondition;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.PatientID;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.PatientStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Patient extends AggregateRoot<PatientID>{

    private BioData bioData;

    private List<MedicalCondition> medicalCondition;

    private PatientStatus patientStatus;

    private Patient(Builder builder) {
        this.setId(builder.id);
        setBioData(builder.bioData);
        setMedicalCondition(builder.medicalCondition);
        setPatientStatus(builder.patientStatus);
    }

    @Override
    public <R extends PatientDomainEvent> void apply(R event) {
        if (event instanceof PatientCreateEvent){
                createPatient(event);
        } else if (event instanceof  PatientUpdateEvent) {
            updatePatient(event);
        } else if (event instanceof PatientDeleteEvent) {
            deletePatient(event);
        } else
            throw new PatientDomainException("Invalid event triggered");
    }

    private void deletePatient(Object entity) {
    }

    private void updatePatient(Object entity) {
    }

    private void createPatient(Object entity) {
        this.setPatientStatus(PatientStatus.ALIVE);
    }

    public static final class Builder {
        private PatientID id;
        private BioData bioData;
        private List<MedicalCondition> medicalCondition;
        private PatientStatus patientStatus;

        private Builder() {
        }

        public static Builder newPatient() {
            return new Builder();
        }

        public Builder withId(PatientID val) {
            id = val;
            return this;
        }

        public Builder withBioData(BioData val) {
            bioData = val;
            return this;
        }

        public Builder withMedicalCondition(List<MedicalCondition> val) {
            medicalCondition = val;
            return this;
        }

        public Builder withPatientStatus(PatientStatus val) {
            patientStatus = val;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }
}
