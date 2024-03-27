package com.neudesic.patientmanagmentsystem.application.query;

import com.neudesic.patientmanagmentsystem.domain.entities.Entity;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
     List<? extends Entity> handle(T query);
}
