package com.clinic.management.domain.services.order;

import com.clinic.management.domain.model.order.MedicationOrder;
import com.clinic.management.domain.ports.order.MedicationOrderPort;

public class CreateMedicationOrder {

    private final MedicationOrderPort medicationOrderPort;

    public CreateMedicationOrder(MedicationOrderPort medicationOrderPort) {
        this.medicationOrderPort = medicationOrderPort;
    }

    public void create(MedicationOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden de medicamento no puede ser nula");
        }
        if (order.getPatientId() <= 0) {
            throw new Exception("Debe estar asociada a un paciente");
        }
        if (order.getMedicationId() <= 0) {
            throw new Exception("Debe indicar el medicamento");
        }
        if (order.getPrescribedBy() <= 0) {
            throw new Exception("Debe estar asociada a un médico que prescribe");
        }
        if (order.getDosage() == null || order.getDosage().isEmpty()) {
            throw new Exception("La dosis es obligatoria");
        }

        if (medicationOrderPort.findById(order.getId()) != null) {
            throw new Exception("Ya existe una orden de medicamento con ese ID");
        }

        medicationOrderPort.save(order);
    }
}
