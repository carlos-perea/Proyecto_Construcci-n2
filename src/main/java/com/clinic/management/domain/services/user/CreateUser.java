package com.clinic.management.domain.services.user;

import com.clinic.management.domain.model.user.User;
import com.clinic.management.domain.ports.user.UserPort;

import java.time.LocalDate;
import java.time.Period;

public class CreateUser {

    private final UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void create(User user) throws Exception {
        // Validar cédula única
        if (userPort.findByDocument(user) != null) {
            throw new Exception("Ya existe una persona registrada con esa cédula");
        }

        // Validar nombre de usuario único
        if (userPort.findByUserName(user) != null) {
            throw new Exception("Ya existe una persona registrada con ese nombre de usuario");
        }

        // Validar correo
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Correo electrónico no válido");
        }

        // Validar teléfono
        if (user.getPhone() == null || !user.getPhone().matches("\\d{1,10}")) {
            throw new Exception("Número de teléfono inválido, debe tener entre 1 y 10 dígitos");
        }

        // Validar fecha de nacimiento (máx 150 años)
        if (user.getBirthDate() != null) {
            LocalDate now = LocalDate.now();
            int age = Period.between(user.getBirthDate(), now).getYears();
            if (age > 150) {
                throw new Exception("La edad no puede ser mayor a 150 años");
            }
        }

        // Validar dirección
        if (user.getAddress() != null && user.getAddress().length() > 30) {
            throw new Exception("La dirección no puede superar 30 caracteres");
        }

        // Validar rol
        if (user.getRole() == null) {
            throw new Exception("El rol es obligatorio");
        }

        // Guardar usuario
        userPort.save(user);
    }
}
