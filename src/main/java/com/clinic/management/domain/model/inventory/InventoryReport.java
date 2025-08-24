package com.clinic.management.domain.model.inventory;

public class InventoryReport {
    int id;
    String reportDate;
    String generatedBy;
    int totalItems;
    String notes;
    int outOfStockCount;
    int expiringSoonCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getOutOfStockCount() {
        return outOfStockCount;
    }

    public void setOutOfStockCount(int outOfStockCount) {
        this.outOfStockCount = outOfStockCount;
    }

    public int getExpiringSoonCount() {
        return expiringSoonCount;
    }

    public void setExpiringSoonCount(int expiringSoonCount) {
        this.expiringSoonCount = expiringSoonCount;
    }
}
