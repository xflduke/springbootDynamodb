package io.duke.demo.controller;

import io.duke.demo.model.UserInfo;
import io.duke.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserInfo userInfo = (UserInfo) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userInfo.getUsername().length() < 6 || userInfo.getUsername().length() > 32) {
            errors.rejectValue("username", "Size");
        }
        if (userService.findByUsername(userInfo.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userInfo.getPassword().length() < 8 || userInfo.getPassword().length() > 32) {
            errors.rejectValue("password", "Size");
        }

        if (!userInfo.getPasswordConfirm().equals(userInfo.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff");
        }
    }
}
