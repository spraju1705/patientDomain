package com.neudesic.patientmanagmentsystem.controller.dto;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class QueryResponse {
    private Status status;
    private List<? extends Entity> entity;
}
