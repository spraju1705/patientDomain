package com.neudesic.patientmanagmentsystem.application.command;

import com.neudesic.patientmanagmentsystem.application.message.Message;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseCommand <T> extends Message {

    private T dto;

    public BaseCommand(UUID id, T dto) {
        super(id);
        this.dto = dto;
    }
}

