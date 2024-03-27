package com.neudesic.patientmanagmentsystem.domain.exceptions;

public class PatientDomainException extends RuntimeException{
    public PatientDomainException(String message) {
        super(message);
    }

    public PatientDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
