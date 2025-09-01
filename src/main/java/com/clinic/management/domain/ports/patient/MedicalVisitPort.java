package com.clinic.management.domain.ports.patient;

import com.clinic.management.domain.model.patient.MedicalVisit;

public interface MedicalVisitPort {
    MedicalVisit findById(int id);
    void save(MedicalVisit visit);
}

