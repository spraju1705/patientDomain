package com.neudesic.patientmanagmentsystem.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCondition {

    private  Disease disease;

    private  MedicalConditionStage medicalConditionStage;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCondition that = (MedicalCondition) o;
        return Objects.equals(disease, that.disease) && medicalConditionStage == that.medicalConditionStage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(disease, medicalConditionStage);
    }

    private Boolean isValidMedicalCondition(){
        return  (this.disease != null && this.medicalConditionStage !=null);
    }
}
