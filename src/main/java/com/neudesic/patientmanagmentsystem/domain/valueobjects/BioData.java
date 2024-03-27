package com.neudesic.patientmanagmentsystem.domain.valueobjects;

import com.neudesic.patientmanagmentsystem.domain.exceptions.PatientDomainException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@Data
@NoArgsConstructor
public class BioData {

    private   String name;

    private  LocalDate dateOfBirth;

    private  String address;


    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public BioData(String name, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BioData bioData = (BioData) o;
        return Objects.equals(name, bioData.name) && Objects.equals(dateOfBirth, bioData.dateOfBirth) && Objects.equals(address, bioData.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, address);
    }

    public Boolean isValidBioData(){
        var validity = this.address!=null && this.name!=null && this.dateOfBirth!=null && this.dateOfBirth.isBefore(LocalDate.now());
        if (validity){
            return true;
        }else {
            throw new PatientDomainException("Patient details are invalid");
        }
    }


}
