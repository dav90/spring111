//package com.springapp.mvc.service.impl;
//
//import com.springapp.mvc.exception.DatabaseException;
//import com.springapp.mvc.model.User;
//import com.springapp.mvc.repository.IUserRepository;
//import com.springapp.mvc.service.IUserManager;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import java.util.List;
//
////@Service
//public class UserManager implements IUserManager {
//
//    @Autowired
//    private IUserRepository repository;
//
//    @Override
//    public void addUser(User user) throws DatabaseException {
//        repository.addUser(user);
//    }
//
//    @Override
//    public void removeUser(User user) {
//        repository.removeUser(user);
//    }
//
//    @Override
//    public User findUserByEmail(String email) {
//        return repository.findUserByEmail(email);
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        return repository.getAllUser();
//    }
//
//    @Override
//    public void changeUser(String email, User user) {
//        repository.changeUser(email, user);
//    }
//
//    @Override
//    public boolean isExistingUser(String email, String password) {
//        return repository.isExistingUser(email, password);
//    }
//}
