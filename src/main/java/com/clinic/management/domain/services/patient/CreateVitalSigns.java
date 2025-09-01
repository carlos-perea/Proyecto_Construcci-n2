package com.clinic.management.domain.services.patient;

import com.clinic.management.domain.model.patient.VitalSigns;
import com.clinic.management.domain.ports.patient.VitalSignsPort;

public class CreateVitalSigns {

    private final VitalSignsPort vitalSignsPort;

    public CreateVitalSigns(VitalSignsPort vitalSignsPort) {
        this.vitalSignsPort = vitalSignsPort;
    }

    public void create(VitalSigns signs) throws Exception {
        if (signs == null) {
            throw new Exception("Los signos vitales no pueden ser nulos");
        }

        if (signs.getPatientId() <= 0) {
            throw new Exception("El paciente asociado es obligatorio");
        }

        if (signs.getTemperature() <= 0) {
            throw new Exception("La temperatura debe ser válida");
        }

        if (signs.getHeartRate() <= 0) {
            throw new Exception("El ritmo cardíaco debe ser válido");
        }

        // Evitar duplicados
        if (vitalSignsPort.findById(signs.getId()) != null) {
            throw new Exception("Ya existen signos vitales con ese ID");
        }

        vitalSignsPort.save(signs);
    }
}
