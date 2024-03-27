package com.neudesic.patientmanagmentsystem.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UpdateResponse {
    private Status status;
    private String message;
}
