package com.springapp.mvc.controller;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserManager;
import com.springapp.mvc.service.impl.AddressManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "addAddress")
public class AddAddress {
    @RequestMapping(method = RequestMethod.GET)
    private String initContactForm(Model model, User user) {
        model.addAttribute("user", user);
        return "addAddress";
    }

    @Autowired
    UserManager manager;

    @Autowired
    AddressManager addressManager;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(method = RequestMethod.POST)
    private String addAddressToUser(HttpServletRequest request,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "street") String street) throws DatabaseException {
        String path = "userHome";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (StringUtils.isEmpty(city) && StringUtils.isEmpty(street)) {
            path = "addAddress";
        } else {
            Address address = new Address();
            address.setCity(city);
            address.setStreet(street);
            User contactUser = manager.findUserByEmail(currentUser.getEmail());
            try {
                request.getSession().getAttribute("user");
                addressManager.addAddress(address);
            } catch (Exception e) {
                throw new DatabaseException("Can't add address", e);
            }

//            List<Address> addressList = contactUser.getAddress();
//            addressList.add(address);
//            contactUser.setAddress(addressList);
            manager.changeUser(currentUser, address);

        }

        return "redirect:" + path;
    }
}

