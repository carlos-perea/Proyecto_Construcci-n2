package com.clinic.management.domain.ports.billing;

import com.clinic.management.domain.model.billing.Billing;

public interface BillingPort {
    Billing findById(int billingId);
    void save(Billing billing);
}
