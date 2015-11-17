package com.springapp.mvc.controller;

import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserManager;
import com.springapp.mvc.service.impl.AddressManager;
import com.springapp.mvc.service.impl.ContactManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Users {

    @Autowired
    IUserManager manager;

    @Autowired
    AddressManager addressManager;

    @Autowired
    ContactManager contactManager;

    @Autowired
    HttpSession session;

    @RequestMapping(value = "userHome",method = {RequestMethod.POST,RequestMethod.GET})

    private String getUsers(Model model) {
        List userList = manager.getAllUser();
        User user = (User) session.getAttribute("currentUser");
//        List addressList = addressManager.getAllAddress();
//        List contactList = contactManager.getAllContact();
        List<Address> addressList = user.getAddress();
        List<Contact> contactList = user.getContact();
        model.addAttribute("users", userList);
        model.addAttribute("address", addressList);
        model.addAttribute("contact", contactList);
        return "user";
    }


}
