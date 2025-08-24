package com.clinic.management.domain.model.order;

public class DiagnosticTest {
    int id;
    int diagnosticOrderId;
    String testName;
    String result;
    String resultDate;
    String laboratory;
    String referenceRange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiagnosticOrderId() {
        return diagnosticOrderId;
    }

    public void setDiagnosticOrderId(int diagnosticOrderId) {
        this.diagnosticOrderId = diagnosticOrderId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }
}
