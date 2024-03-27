package com.neudesic.patientmanagmentsystem.controller;


import com.neudesic.patientmanagmentsystem.application.command.CreatePatientCommand;
import com.neudesic.patientmanagmentsystem.application.command.DeletePatientCommand;
import com.neudesic.patientmanagmentsystem.application.command.PatientCommandDispatcher;
import com.neudesic.patientmanagmentsystem.application.query.FindAllPatientsQuery;
import com.neudesic.patientmanagmentsystem.application.query.FindPatientQuery;
import com.neudesic.patientmanagmentsystem.application.query.FindPatientsBySearchCriteriaQuery;
import com.neudesic.patientmanagmentsystem.application.query.PatientQueryDispatcher;
import com.neudesic.patientmanagmentsystem.controller.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class PatientController {

    @Autowired
    PatientCommandDispatcher patientCommandDispatcher;

    @Autowired
    PatientQueryDispatcher patientQueryDispatcher;

    @PostMapping("/create")
    public ResponseEntity<UpdateResponse> createPatient(@RequestBody CreatePatientDTO createPatientDTO){
        try {
            var response = patientCommandDispatcher.send(new CreatePatientCommand(UUID.randomUUID(), createPatientDTO));
            log.info("Patient ID "+ response.getId() + "created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(UpdateResponse.builder().status(Status.SUCCESS).message(response.getMessage()).build());
        } catch (Exception e) {
            log.error("Patient created failed due to "+e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(UpdateResponse.builder().status(Status.FAILURE).message("Error occured "+ e.getMessage()).build());
        }
    }

    @GetMapping("/getALlPatients")
    public ResponseEntity<QueryResponse> getAllPatients(){
        try {
            var patients = patientQueryDispatcher.send( new FindAllPatientsQuery());
            log.info("All Patient details fetched successfully");
            return ResponseEntity.status(HttpStatus.OK).body(QueryResponse.builder().status(Status.SUCCESS).entity(patients).build());
        } catch (Exception e) {
            log.error("Error in fetching patients details "+ e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(QueryResponse.builder().status(Status.FAILURE).entity(List.of()).build());
        }
    }

    @GetMapping("/getPatient/{id}")
    public ResponseEntity<QueryResponse> getPatient(@PathVariable String id){
        try {
            var patient = patientQueryDispatcher.send(FindPatientQuery.builder().id(UUID.fromString(id)).build());
            log.info("Patient details fetched successfully");
            return ResponseEntity.status(HttpStatus.OK).body(QueryResponse.builder().status(Status.SUCCESS).entity(patient).build());
        } catch (Exception e) {
            log.error("Error in fetching patients details "+ e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(QueryResponse.builder().status(Status.FAILURE).entity(List.of()).build());
        }
    }

    @DeleteMapping("deletePatient/{id}")
    public ResponseEntity<UpdateResponse> deletePatient(@PathVariable String id){
        try {
            var response = patientCommandDispatcher.send(DeletePatientCommand.builder().id(UUID.fromString(id)).build());
            log.info("Patient ID "+ response.getId() + "created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(UpdateResponse.builder().status(Status.SUCCESS).message(response.getMessage()).build());
        } catch (Exception e) {
            log.error("Patient created failed due to "+e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(UpdateResponse.builder().status(Status.FAILURE).message("Error occurred "+ e.getMessage()).build());
        }
    }


    @PostMapping("/getPatientsByCriteria")
    public ResponseEntity<QueryResponse> getPatientBySearchCriteria(@RequestBody SearchCriteriaDTO searchCriteriaDTO){
        try {
            var patient = patientQueryDispatcher.send(
                    FindPatientsBySearchCriteriaQuery.builder().name(searchCriteriaDTO.getName()).build());
            log.info("Patient details fetched successfully");
            return ResponseEntity.status(HttpStatus.OK).body(QueryResponse.builder().status(Status.SUCCESS).entity(patient).build());
        } catch (Exception e) {
            log.error("Error in fetching patients details "+ e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(QueryResponse.builder().status(Status.FAILURE).entity(List.of()).build());
        }
    }



}
