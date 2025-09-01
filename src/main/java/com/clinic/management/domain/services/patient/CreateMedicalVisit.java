package com.clinic.management.domain.services.patient;

import com.clinic.management.domain.model.patient.MedicalVisit;
import com.clinic.management.domain.ports.patient.MedicalVisitPort;

public class CreateMedicalVisit {

    private final MedicalVisitPort medicalVisitPort;

    public CreateMedicalVisit(MedicalVisitPort medicalVisitPort) {
        this.medicalVisitPort = medicalVisitPort;
    }

    public void create(MedicalVisit visit) throws Exception {
        if (visit == null) {
            throw new Exception("La visita médica no puede ser nula");
        }

        if (visit.getPatientId() <= 0) {
            throw new Exception("El paciente asociado es obligatorio");
        }

        if (visit.getDoctorId() <= 0) {
            throw new Exception("El doctor asociado es obligatorio");
        }

        if (visit.getVisitDate() == null || visit.getVisitDate().isBlank()) {
            throw new Exception("La fecha de la visita es obligatoria");
        }

        // Evitar duplicados
        if (medicalVisitPort.findById(visit.getId()) != null) {
            throw new Exception("Ya existe una visita médica con ese ID");
        }

        medicalVisitPort.save(visit);
    }
}
