package com.neudesic.patientmanagmentsystem.application.command;

public interface CommandHandlerMethod<T extends BaseCommand> {
    UpdateCommandResponse handle(T command);
}
