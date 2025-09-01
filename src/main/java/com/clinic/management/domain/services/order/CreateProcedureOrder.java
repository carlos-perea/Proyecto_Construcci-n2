package com.clinic.management.domain.services.order;

import com.clinic.management.domain.model.order.ProcedureOrder;
import com.clinic.management.domain.ports.order.ProcedureOrderPort;

public class CreateProcedureOrder {

    private final ProcedureOrderPort procedureOrderPort;

    public CreateProcedureOrder(ProcedureOrderPort procedureOrderPort) {
        this.procedureOrderPort = procedureOrderPort;
    }

    public void create(ProcedureOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden de procedimiento no puede ser nula");
        }
        if (order.getPatientId() <= 0) {
            throw new Exception("Debe estar asociada a un paciente");
        }
        if (order.getProcedureId() <= 0) {
            throw new Exception("Debe indicar el procedimiento");
        }
        if (order.getPerformedBy() <= 0) {
            throw new Exception("Debe estar asociada a un médico responsable");
        }
        if (order.getScheduledDate() == null || order.getScheduledDate().isEmpty()) {
            throw new Exception("Debe indicar la fecha programada");
        }

        if (procedureOrderPort.findById(order.getId()) != null) {
            throw new Exception("Ya existe una orden de procedimiento con ese ID");
        }

        procedureOrderPort.save(order);
    }
}
