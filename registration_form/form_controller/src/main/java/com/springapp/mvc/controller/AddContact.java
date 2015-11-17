package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserManager;
import com.springapp.mvc.service.impl.ContactManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "addContact")
public class AddContact {

    @Autowired
    UserManager manager;

    @Autowired
    ContactManager contactManager;

    @RequestMapping(method = RequestMethod.GET)
    private String initContactForm(Model model, User user) {
        model.addAttribute("user", user);
        return "addContact";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String addContactToUser(Model model, HttpServletRequest request,
                                    @RequestParam(value = "mobileNumber") String mobileNumber,
                                    @RequestParam(value = "homeNumber") String homeNumber)
            throws DatabaseException {
        String path = "userHome";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (StringUtils.isEmpty(mobileNumber) && StringUtils.isEmpty(homeNumber)) {
            path = "addContact";
        } else {
            Contact contact = new Contact();
            contact.setHomeNumber(homeNumber);
            contact.setMobileNumber(mobileNumber);
            User contactUser = manager.findUserByEmail(currentUser.getEmail());

            contactManager.addContact(contactUser, contact);
            //manager.changeUser(contactUser);
//            List<Contact> list = manager.findUserByEmail(currentUser.getEmail()).getContact();
//            if (list == null) {
//                list = new LinkedList<Contact>();
//            }
//            list.add(contact);
//            contactUser.setContact(list);

        }
        return "redirect:"+path;
    }

}
