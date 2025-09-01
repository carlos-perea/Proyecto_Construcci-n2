package com.clinic.management.application;

import com.clinic.management.domain.model.order.DiagnosticOrder;
import com.clinic.management.domain.model.order.MedicationOrder;
import com.clinic.management.domain.model.order.ProcedureOrder;
import com.clinic.management.domain.services.order.CreateDiagnosticOrder;
import com.clinic.management.domain.services.order.CreateMedicationOrder;
import com.clinic.management.domain.services.order.CreateProcedureOrder;

public class SupportStaffUseCase {

    private final CreateDiagnosticOrder createDiagnosticOrder;
    private final CreateMedicationOrder createMedicationOrder;
    private final CreateProcedureOrder createProcedureOrder;

    public SupportStaffUseCase(CreateDiagnosticOrder createDiagnosticOrder,
                               CreateMedicationOrder createMedicationOrder,
                               CreateProcedureOrder createProcedureOrder) {
        this.createDiagnosticOrder = createDiagnosticOrder;
        this.createMedicationOrder = createMedicationOrder;
        this.createProcedureOrder = createProcedureOrder;
    }

    public void createDiagnosticOrder(DiagnosticOrder order) throws Exception {
        createDiagnosticOrder.create(order);
    }

    public void createMedicationOrder(MedicationOrder order) throws Exception {
        createMedicationOrder.create(order);
    }

    public void createProcedureOrder(ProcedureOrder order) throws Exception {
        createProcedureOrder.create(order);
    }
}
