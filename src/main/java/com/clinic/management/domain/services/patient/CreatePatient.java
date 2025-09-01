package com.clinic.management.domain.services.patient;

import com.clinic.management.domain.model.patient.Patient;
import com.clinic.management.domain.ports.patient.PatientPort;

public class CreatePatient {

    private final PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }

        if (patient.getFullName() == null || patient.getFullName().isBlank()) {
            throw new Exception("El nombre completo es obligatorio");
        }

        if (patient.getBirthDate() == null || patient.getBirthDate().isBlank()) {
            throw new Exception("La fecha de nacimiento es obligatoria");
        }

        if (patient.getPhone() != null && patient.getPhone().length() != 10) {
            throw new Exception("El teléfono debe tener 10 dígitos");
        }

        if (patient.getAddress() != null && patient.getAddress().length() > 30) {
            throw new Exception("La dirección no puede superar 30 caracteres");
        }

        // Evitar duplicados por ID
        if (patientPort.findById(patient.getId()) != null) {
            throw new Exception("Ya existe un paciente con ese ID");
        }

        patientPort.save(patient);
    }
}

