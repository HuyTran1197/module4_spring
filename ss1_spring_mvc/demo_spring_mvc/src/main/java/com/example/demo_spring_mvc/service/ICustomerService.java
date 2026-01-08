package com.example.demo_spring_mvc.service;

import com.example.demo_spring_mvc.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer findById (int id);
}
