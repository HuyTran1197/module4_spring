package com.example.demo_form_validate.service;

import com.example.demo_form_validate.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean save(User user);
}
