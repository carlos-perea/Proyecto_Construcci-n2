package com.clinic.management.domain.services.inventory;

import com.clinic.management.domain.model.inventory.Inventory;
import com.clinic.management.domain.model.inventory.InventoryReport;
import com.clinic.management.domain.ports.InventoryPort;

import java.util.List;

public class CreateInventory {

    private final InventoryPort inventoryPort;

    public CreateInventory(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    // Crear un nuevo item de inventario
    public void create(Inventory inventory) throws Exception {
        if (inventoryPort.findByName(inventory.getItemName()) != null) {
            throw new Exception("Ya existe un item con ese nombre en el inventario");
        }
        inventoryPort.save(inventory);
    }

    // Actualizar el stock de un item existente
    public void updateStock(int inventoryId, int newStock) throws Exception {
        Inventory item = inventoryPort.findById(inventoryId);
        if (item == null) {
            throw new Exception("No se encontró el item en el inventario");
        }
        item.setCurrentStock(newStock);
        inventoryPort.save(item);
    }

    // Generar un reporte del inventario
    public InventoryReport generateReport(String generatedBy) {
        List<Inventory> items = inventoryPort.findAll();
        InventoryReport report = new InventoryReport();

        report.setGeneratedBy(generatedBy);
        report.setTotalItems(items.size());
        report.setOutOfStockCount((int) items.stream().filter(i -> i.getCurrentStock() == 0).count());
        report.setExpiringSoonCount(0);
        report.setNotes("Reporte generado automáticamente");

        return report;
    }
}

