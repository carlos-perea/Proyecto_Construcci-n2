package com.clinic.management.domain.services.patient;

import com.clinic.management.domain.model.patient.MedicalRecord;
import com.clinic.management.domain.ports.patient.MedicalRecordPort;

public class CreateMedicalRecord {

    private final MedicalRecordPort medicalRecordPort;

    public CreateMedicalRecord(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    public void create(MedicalRecord record) throws Exception {
        if (record == null) {
            throw new Exception("La historia clínica no puede ser nula");
        }

        if (record.getPatientId() <= 0) {
            throw new Exception("El paciente asociado es obligatorio");
        }

        if (record.getRecordDate() == null || record.getRecordDate().isBlank()) {
            throw new Exception("La fecha de registro es obligatoria");
        }

        // Evitar duplicados por ID
        if (medicalRecordPort.findById(record.getId()) != null) {
            throw new Exception("Ya existe una historia clínica con ese ID");
        }

        medicalRecordPort.save(record);
    }
}
