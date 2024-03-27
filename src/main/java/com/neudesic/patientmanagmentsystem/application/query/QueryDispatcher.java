package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    List<? extends Entity> send(BaseQuery query);
}
