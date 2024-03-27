package com.neudesic.patientmanagmentsystem.infrastructure.repository;

import com.neudesic.patientmanagmentsystem.application.query.FindPatientsBySearchCriteriaQuery;
import com.neudesic.patientmanagmentsystem.domain.valueobjects.Disease;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.PatientEntity;
import com.neudesic.patientmanagmentsystem.infrastructure.entity.QPatientEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

@Repository
public class PatientCustomSearchRepository {

    @Autowired
    private EntityManager entityManager;

    QPatientEntity patient = QPatientEntity.patientEntity;

    public List<PatientEntity> findPatients(FindPatientsBySearchCriteriaQuery query) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        return queryFactory.selectFrom(patient).where(
                nameEquals(query.getName())
        ).fetch();
    }

    private BooleanExpression nameEquals(String name) {
        return name != null ? patient.bioData.name.eq(name) : null;
    }

//    private BooleanExpression dobEquals(LocalDate dob) {
//        return dob != null ? patient.dob.eq(dob) : null;
//    }
//
//    private BooleanExpression dobAccuracyEquals(DobSearchAccuracy dobAccuracy) {
//        return dobAccuracy != null ? yourEntity.dobAccuracy.eq(dobAccuracy) : null;
//    }
//
//    private BooleanExpression diseaseEquals(Disease disease) {
//        return disease != null ? patient..disease.eq(disease) : null;
//    }

}
