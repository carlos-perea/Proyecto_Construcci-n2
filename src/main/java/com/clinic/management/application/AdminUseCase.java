package com.clinic.management.application;

import com.clinic.management.domain.model.user.User;
import com.clinic.management.domain.model.enums.Role;
import com.clinic.management.domain.services.user.CreateUser;

public class AdminUseCase {

    private final CreateUser createUser;

    public AdminUseCase(CreateUser createUser) {
        this.createUser = createUser;
    }

    public void createDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        createUser.create(user);
    }

    public void createNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        createUser.create(user);
    }

    public void createSupportStaff(User user) throws Exception {
        user.setRole(Role.SUPPORT_STAFF);
        createUser.create(user);
    }

    public void createHumanResources(User user) throws Exception {
        user.setRole(Role.HUMAN_RESOURCES);
        createUser.create(user);
    }
}
