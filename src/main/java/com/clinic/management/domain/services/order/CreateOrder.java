package com.clinic.management.domain.services.order;

import com.clinic.management.domain.model.order.Order;
import com.clinic.management.domain.ports.order.OrderPort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrder {

    private final OrderPort orderPort;

    public CreateOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void create(Order order) throws Exception {
        if (order == null) {
            throw new Exception("La orden no puede ser nula");
        }

        if (orderPort.findById(order.getId()) != null) {
            throw new Exception("Ya existe una orden con ese número");
        }

        if (order.getOrderType() == null || order.getOrderType().isBlank()) {
            throw new Exception("El tipo de orden es obligatorio (Medication, Procedure, Test)");
        }

        if (order.getOrderDate() == null || order.getOrderDate().isBlank()) {
            String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            order.setOrderDate(today);
        }

        order.setStatus("CREATED");

        orderPort.save(order);
    }
}
