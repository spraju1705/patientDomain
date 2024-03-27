package com.neudesic.patientmanagmentsystem.application.query;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class FindPatientQuery extends BaseQuery{
    private UUID id;
}
