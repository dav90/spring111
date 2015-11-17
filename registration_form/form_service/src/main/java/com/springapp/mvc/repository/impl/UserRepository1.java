//package com.springapp.mvc.repository.impl;
//
//import com.springapp.mvc.model.User;
//import com.springapp.mvc.repository.IUserRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.LinkedList;
//import java.util.List;
//
////@Repository
//public class UserRepository implements IUserRepository {
//
//    private List<User> userList ;
//
//    @Override
//    public void addUser(User user) {
//        userList.add(user);
//    }
//
//    @Override
//    public void removeUser(User user) {
//        userList.remove(user);
//    }
//
//    @Override
//    public User findUserByEmail(String email) {
//        if (userList.size() > 0) {
//            for (User user : userList) {
//                if (user.getEmail().equals(email)) {
//                    return user;
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        return userList;
//    }
//
//    @Override
//    public void changeUser(String email, User user) {
//
//    }
//
//    @Override
//    public boolean isExistingUser(String email,String password) {
//        if (findUserByEmail(email) != null  && password.equals(findUserByEmail(email).getPassword())) {
//            return true;
//        }
//        return false;
//    }
//    @PostConstruct
//    public void init(){
//        userList = new LinkedList();
//    }
//
//}
