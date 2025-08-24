package com.clinic.management.domain.model.user;

import com.clinic.management.domain.model.enums.Role;

public class User extends Person{

    private String userName ;
    private String password ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }
}
