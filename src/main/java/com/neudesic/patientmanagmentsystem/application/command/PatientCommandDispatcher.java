package com.neudesic.patientmanagmentsystem.application.command;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PatientCommandDispatcher implements CommandDispatcher{


    @Autowired
    CreatePatientCommandHandler createPatientCommandHandler;

    @Autowired
    UpdatePatientCommandHandler updatePatientCommandHandler;

    @Autowired
    DeletePatientCommandHandler deletePatientCommandHandler;

    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler) {
        var handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public UpdateCommandResponse send(BaseCommand command) {
        var handlers = routes.get(command.getClass());
        if (handlers == null || handlers.size() == 0) {
            throw new RuntimeException("No command handler was registered!");
        }

        return handlers.get(0).handle(command);
    }

    @PostConstruct
    public void registerHandlers() {
        registerHandler(CreatePatientCommand.class, createPatientCommandHandler);
        registerHandler(UpdatePatientCommand.class, updatePatientCommandHandler);
        registerHandler(DeletePatientCommand.class, deletePatientCommandHandler);
    }

}
