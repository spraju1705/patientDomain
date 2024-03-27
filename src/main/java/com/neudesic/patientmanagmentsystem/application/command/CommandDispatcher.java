package com.neudesic.patientmanagmentsystem.application.command;

public interface CommandDispatcher  {
    <T extends BaseCommand>void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    UpdateCommandResponse send(BaseCommand command);
}
