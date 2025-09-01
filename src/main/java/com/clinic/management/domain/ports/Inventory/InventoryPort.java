package com.clinic.management.domain.ports;

import com.clinic.management.domain.model.inventory.Inventory;

import java.util.List;

public interface InventoryPort {
    Inventory findById(int id);
    Inventory findByName(String itemName);
    List<Inventory> findAll();
    void save(Inventory inventory);
}
