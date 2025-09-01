package com.clinic.management.domain.ports.order;

import com.clinic.management.domain.model.order.DiagnosticOrder;

public interface DiagnosticOrderPort {
    DiagnosticOrder findById(int id);
    void save(DiagnosticOrder order);
}
