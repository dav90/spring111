package com.springapp.mvc.controller.validator;

import com.springapp.mvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "valid.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");

    }
}
