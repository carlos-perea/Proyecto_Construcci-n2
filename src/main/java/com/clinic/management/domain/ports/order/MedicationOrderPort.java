package com.clinic.management.domain.ports.order;

import com.clinic.management.domain.model.order.MedicationOrder;

public interface MedicationOrderPort {
    MedicationOrder findById(int id);
    void save(MedicationOrder order);
}
