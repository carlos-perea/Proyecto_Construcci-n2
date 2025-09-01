package com.clinic.management.application;

import com.clinic.management.domain.model.user.User;
import com.clinic.management.domain.model.enums.Role;

// Modelos
import com.clinic.management.domain.model.patient.Patient;
import com.clinic.management.domain.model.patient.MedicalRecord;
import com.clinic.management.domain.model.patient.MedicalVisit;
import com.clinic.management.domain.model.patient.VitalSigns;
import com.clinic.management.domain.model.order.DiagnosticOrder;
import com.clinic.management.domain.model.order.MedicationOrder;
import com.clinic.management.domain.model.order.ProcedureOrder;

// Servicios
import com.clinic.management.domain.services.user.CreateUser;
import com.clinic.management.domain.services.patient.CreatePatient;
import com.clinic.management.domain.services.patient.CreateMedicalRecord;
import com.clinic.management.domain.services.patient.CreateMedicalVisit;
import com.clinic.management.domain.services.patient.CreateVitalSigns;
import com.clinic.management.domain.services.order.CreateDiagnosticOrder;
import com.clinic.management.domain.services.order.CreateMedicationOrder;
import com.clinic.management.domain.services.order.CreateProcedureOrder;

public class DoctorUseCase {

    private final CreateUser createUser;
    private final CreatePatient createPatient;
    private final CreateMedicalRecord createMedicalRecord;
    private final CreateMedicalVisit createMedicalVisit;
    private final CreateVitalSigns createVitalSigns;

    private final CreateDiagnosticOrder createDiagnosticOrder;
    private final CreateMedicationOrder createMedicationOrder;
    private final CreateProcedureOrder createProcedureOrder;

    public DoctorUseCase(CreateUser createUser,
                         CreatePatient createPatient,
                         CreateMedicalRecord createMedicalRecord,
                         CreateMedicalVisit createMedicalVisit,
                         CreateVitalSigns createVitalSigns,
                         CreateDiagnosticOrder createDiagnosticOrder,
                         CreateMedicationOrder createMedicationOrder,
                         CreateProcedureOrder createProcedureOrder) {
        this.createUser = createUser;
        this.createPatient = createPatient;
        this.createMedicalRecord = createMedicalRecord;
        this.createMedicalVisit = createMedicalVisit;
        this.createVitalSigns = createVitalSigns;
        this.createDiagnosticOrder = createDiagnosticOrder;
        this.createMedicationOrder = createMedicationOrder;
        this.createProcedureOrder = createProcedureOrder;
    }

    // Crear paciente
    public void createPatient(Patient patient) throws Exception {
        createPatient.create(patient);
    }

    // Crear registro médico
    public void createMedicalRecord(MedicalRecord record) throws Exception {
        createMedicalRecord.create(record);
    }

    // Crear visita médica
    public void createMedicalVisit(MedicalVisit visit) throws Exception {
        createMedicalVisit.create(visit);
    }

    // Crear signos vitales
    public void createVitalSigns(VitalSigns vitalSigns) throws Exception {
        createVitalSigns.create(vitalSigns);
    }

    // Crear órdenes según tipo
    public void createDiagnosticOrder(DiagnosticOrder order) throws Exception {
        createDiagnosticOrder.create(order);
    }

    public void createMedicationOrder(MedicationOrder order) throws Exception {
        createMedicationOrder.create(order);
    }

    public void createProcedureOrder(ProcedureOrder order) throws Exception {
        createProcedureOrder.create(order);
    }

    // Crear propietario/usuario
    public void createOwner(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVE);
        createUser.create(user);
    }
}
