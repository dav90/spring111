package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.service.IUserManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.springapp.mvc.model.User;

@Controller
public class Registration {

    @Autowired
    @Qualifier("registrationValidator")
    private Validator validator;

    @Autowired
    private UserManager manager;

    //boolean isValid = true;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/checkRegistration",method = RequestMethod.POST)
    public String checkForm(Model model,
                            @Validated User user,
                            BindingResult bindingResult) throws DatabaseException {
        String path="registration";
        ObjectError error = new ObjectError("email","Email is already used");

//        if(isValid){
        if (!bindingResult.hasErrors()) {
//            isValid = true;
                path = "login";
                manager.addUser(user);
        }
//    }
//        isValid=false;
        model.addAttribute("user",user);
        return path;
    }

//    @RequestMapping(value = "/checkRegistration", method = RequestMethod.POST)
//    @ResponseBody
//    public String add(Model model,
//                      @RequestParam(value = "name") String firstName, @RequestParam(value = "surname") String lastName,
//                      @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
//
//        String path="registration";
//
//        User user = new User();
//        user.setName(firstName);
//        user.setSurname(lastName);
//        user.setEmail(email);
//        user.setPassword(password);
//        try {
//            manager.addUser(user);
//            path = "login";
//        } catch (DatabaseException e) {
//            return e.getMessage();
//        }
//        model.addAttribute("user",user);
//        return path;
//    }

    @RequestMapping(value = "registration",method = RequestMethod.GET)
    public String initForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


}