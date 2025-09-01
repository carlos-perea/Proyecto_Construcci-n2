package com.clinic.management.domain.ports.order;

import com.clinic.management.domain.model.order.ProcedureOrder;

public interface ProcedureOrderPort {
    ProcedureOrder findById(int id);
    void save(ProcedureOrder order);
}
