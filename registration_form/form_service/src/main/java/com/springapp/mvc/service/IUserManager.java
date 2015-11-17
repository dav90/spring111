package com.springapp.mvc.service;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserManager {

    void addUser(User user) throws DatabaseException;

    void removeUser(User user);

    User findUserByEmail(String email);

    List<User> getAllUser();

    void changeUser(User user, Address address);

    boolean isExistingUser(User user);

    boolean isExistingPassword(String password);


}
