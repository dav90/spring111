package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;
import com.springapp.mvc.service.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserManager {


    @Autowired
    private IUserRepository userRepository;


//    public void setUserRepositoryMySql(IUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void addUser(User user) throws DatabaseException {
            userRepository.addUser(user);
    }


    @Override
    public void removeUser(User user) {
        userRepository.removeUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void changeUser(User user, Address address){
        userRepository.changeUser(user, address);
    }

    @Override
    public boolean isExistingUser(User user){
        return userRepository.isExistingUser(user);
    }

    @Override
    public boolean isExistingPassword(String password){
        return userRepository.isExistingPassword(password);
    }
}
