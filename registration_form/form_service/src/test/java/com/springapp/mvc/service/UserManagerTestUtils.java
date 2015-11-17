package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/9/15.
 */
public class UserManagerTestUtils {

    public static User getUser(){
        User user = new User();
        user.setId(1L);
        return user;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(getUser());
        return users;
    }



}
