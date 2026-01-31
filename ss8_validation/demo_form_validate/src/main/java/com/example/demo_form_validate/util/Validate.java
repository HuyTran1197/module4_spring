package com.example.demo_form_validate.util;

import com.example.demo_form_validate.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class Validate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"không được để trống");
        } else if (!user.getFirstName().matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$")) {
            errors.rejectValue("firstName",null,"sai định dạng");
        } else if (user.getFirstName().length()<5 || user.getFirstName().length()>45) {
            errors.rejectValue("firstName",null,"kí tự tối thiểu là 5, tối đa 45");
        }

        if (user.getLastName().equals("")){
            errors.rejectValue("lastName",null,"không được để trống");
        } else if (!user.getLastName().matches("^[A-Z][a-z]+$")) {
            errors.rejectValue("lastName",null,"sai định dạng");
        }else if (user.getLastName().length()<5 || user.getLastName().length()>45) {
            errors.rejectValue("lastName",null,"kí tự tối thiểu là 5, tối đa 45");
        }

        if (!errors.hasFieldErrors("age")){
            if (user.getAge()==null){
                errors.rejectValue("age",null,"tuổi không được để trống");
            } else if (user.getAge()<18) {
                errors.rejectValue("age",null,"tuổi phải từ 18 trở lên");
            }
        }

        if (user.getPhone().equals("")){
            errors.rejectValue("phone",null,"không được để trống");
        } else if (!user.getPhone().matches("^[0-9]{9,11}$")) {
            errors.rejectValue("phone",null,"số điện thoại phải từ 9 đến 11 số");
        }
        if (user.getEmail().equals("")){
            errors.rejectValue("email",null,"không được để trống");
        } else if (!user.getEmail().matches("^\\w+@([a-z]+.com)(.vn)?$")) {
            errors.rejectValue("email",null,"email không đúng định dạng");
        }
    }
}
