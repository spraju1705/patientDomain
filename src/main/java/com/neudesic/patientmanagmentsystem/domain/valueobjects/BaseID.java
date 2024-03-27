package com.neudesic.patientmanagmentsystem.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;



public abstract class BaseID<T> {
    public  T id;

    public BaseID() {
    }

    protected BaseID(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
