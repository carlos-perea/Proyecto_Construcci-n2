package com.clinic.management.domain.ports.patient;

import com.clinic.management.domain.model.patient.VitalSigns;

public interface VitalSignsPort {
    VitalSigns findById(int id);
    void save(VitalSigns signs);
}
