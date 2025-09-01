package com.clinic.management.domain.services.billing;

import com.clinic.management.domain.model.billing.Billing;
import com.clinic.management.domain.model.billing.BillingItem;
import com.clinic.management.domain.model.billing.Payment;
import com.clinic.management.domain.model.patient.Insurance;
import com.clinic.management.domain.ports.billing.BillingPort;

import java.util.Date;

public class CreateBilling {

    private final BillingPort billingPort;

    public CreateBilling(BillingPort billingPort) {
        this.billingPort = billingPort;
    }

    public void create(Billing billing) throws Exception {
        if (billing == null || billing.getPatient() == null) {
            throw new Exception("La factura debe tener un paciente");
        }
        if (billing.getItems() == null || billing.getItems().isEmpty()) {
            throw new Exception("La factura debe tener ítems");
        }

        double total = 0.0;
        for (BillingItem item : billing.getItems()) {
            double subtotal = item.getSubtotal() > 0 ? item.getSubtotal() : item.getQuantity() * item.getUnitPrice();
            item.setSubtotal(subtotal);
            total += subtotal;
        }

        Insurance insurance = billing.getPatient().getInsurance();
        double copago = (insurance != null && insurance.isActive()) ? 50000.0 : total;
        double aseguradora = (insurance != null && insurance.isActive()) ? total - copago : 0.0;

        billing.setTotalAmount(total);
        billing.setBillingDate(new Date());

        Payment payment = new Payment();
        payment.setAmountPaid(copago);
        payment.setPaymentMethod(aseguradora > 0 ? "COPAGO + ASEGURADORA" : "PACIENTE");
        payment.setPaymentDate(new Date().toString());
        billing.setPayment(payment);

        billingPort.save(billing);
    }
}
