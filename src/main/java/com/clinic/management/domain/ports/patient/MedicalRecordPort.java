package com.clinic.management.domain.ports.patient;

import com.clinic.management.domain.model.patient.MedicalRecord;

public interface MedicalRecordPort {
    MedicalRecord findById(int id);
    void save(MedicalRecord record);
}
