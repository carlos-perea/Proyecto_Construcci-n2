package com.clinic.management.domain.services.order;

import com.clinic.management.domain.model.order.DiagnosticOrder;
import com.clinic.management.domain.ports.order.DiagnosticOrderPort;

public class CreateDiagnosticOrder {

    private final DiagnosticOrderPort diagnosticOrderPort;

    public CreateDiagnosticOrder(DiagnosticOrderPort diagnosticOrderPort) {
        this.diagnosticOrderPort = diagnosticOrderPort;
    }

    public void create(DiagnosticOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden de diagnóstico no puede ser nula");
        }
        if (order.getPatientId() <= 0) {
            throw new Exception("Debe estar asociada a un paciente");
        }
        if (order.getDoctorId() <= 0) {
            throw new Exception("Debe estar asociada a un médico");
        }
        if (order.getOrderDate() == null || order.getOrderDate().isEmpty()) {
            throw new Exception("Debe indicar la fecha de la orden");
        }

        if (diagnosticOrderPort.findById(order.getId()) != null) {
            throw new Exception("Ya existe una orden de diagnóstico con ese ID");
        }

        diagnosticOrderPort.save(order);
    }
}
