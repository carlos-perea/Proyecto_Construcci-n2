package com.clinic.management.domain.ports.patient;

import com.clinic.management.domain.model.patient.Patient;

public interface PatientPort {

    Patient findById(int id);   // Buscar paciente por documento/ID

    Patient findByEmail(String email); // Opcional: buscar por email

    Patient findByPhone(String phone); // Opcional: buscar por teléfono

    void save(Patient patient); // Guardar paciente en BD

    void delete(int id);        // Eliminar paciente por ID
}
