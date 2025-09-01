package com.clinic.management.domain.services.user;

import com.clinic.management.domain.model.user.User;
import com.clinic.management.domain.ports.user.UserPort;

public class UserService {

    private UserPort userPort;

    public void createUser(User User) throws Exception {
        //Validar que sollo exista una persona con la cedula
        if(userPort.findByDocument(User)!=null) {
            throw new Exception("Ya existe una persona registrada con ese documento") ;
        }

        //Validar que solo exista un usuario con ese userName
        if(userPort.findByUserName(User)!=null) {
            throw new Exception("Ya existe una persona registrada con ese nombre de usuario") ;
        }
        userPort.save(User) ;

    }
}
