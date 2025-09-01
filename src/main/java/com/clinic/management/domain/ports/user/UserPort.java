package com.clinic.management.domain.ports.user;

import com.clinic.management.domain.model.user.User;

public interface UserPort {
    public User findByDocument(User user) throws Exception ;
    public User findByUserName(User user) throws Exception ;
    public void save(User user) throws Exception ;

}
