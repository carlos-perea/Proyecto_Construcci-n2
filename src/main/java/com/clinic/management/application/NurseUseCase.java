package com.clinic.management.application;

import com.clinic.management.domain.model.patient.Patient;
import com.clinic.management.domain.model.patient.MedicalVisit;
import com.clinic.management.domain.model.patient.VitalSigns;
import com.clinic.management.domain.services.patient.CreatePatient;
import com.clinic.management.domain.services.patient.CreateMedicalVisit;
import com.clinic.management.domain.services.patient.CreateVitalSigns;

public class NurseUseCase {

    private final CreatePatient createPatient;
    private final CreateMedicalVisit createMedicalVisit;
    private final CreateVitalSigns createVitalSigns;

    public NurseUseCase(CreatePatient createPatient,
                        CreateMedicalVisit createMedicalVisit,
                        CreateVitalSigns createVitalSigns) {
        this.createPatient = createPatient;
        this.createMedicalVisit = createMedicalVisit;
        this.createVitalSigns = createVitalSigns;
    }

    public void createPatient(Patient patient) throws Exception {
        createPatient.create(patient);
    }

    public void createMedicalVisit(MedicalVisit visit) throws Exception {
        createMedicalVisit.create(visit);
    }

    public void createVitalSigns(VitalSigns vitalSigns) throws Exception {
        createVitalSigns.create(vitalSigns);
    }
}
