package com.neudesic.patientmanagmentsystem.application.command;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class UpdateCommandResponse {
    private UUID id;
    private String message;
}
