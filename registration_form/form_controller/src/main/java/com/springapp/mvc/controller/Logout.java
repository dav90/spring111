package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;

import com.springapp.mvc.service.IUserManager;
import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Logout {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String setUserOffline(Model model) {

        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            user = userManager.findUserByEmail(user.getEmail());
//            onlineUser.setOnline(false);
            request.getSession().invalidate();
        }
        model.addAttribute("user", new User());
        return "redirect:login";
    }

}
