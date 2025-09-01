package com.clinic.management.domain.ports.order;

import com.clinic.management.domain.model.order.Order;

public interface OrderPort {
    Order findById(int id);
    void save(Order order);
    void delete(int id);
}
