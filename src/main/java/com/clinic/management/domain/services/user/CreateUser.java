package com.clinic.management.domain.services.user;

import com.clinic.management.domain.model.user.User;
import com.clinic.management.domain.ports.UserPort;

public class CreateUser {
    private final UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void execute(User user) throws Exception {
        // Validar documento único
        if (userPort.findByDocument(user.getDocumentId()) != null) {
            throw new Exception("Ya existe una persona registrada con el documento: " + user.getDocumentId());
        }

        // Validar username único
        if (userPort.findByUserName(user.getUserName()) != null) {
            throw new Exception("Ya existe un usuario registrado con el nombre de usuario: " + user.getUserName());
        }

        // Validar contraseña
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new Exception("El usuario debe tener una contraseña válida.");
        }

        // Guardar
        userPort.save(user);
    }

}
