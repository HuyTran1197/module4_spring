package com.example.demo_product.service;

import com.example.demo_product.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(long id);
    Customer save(Customer customer);
    void remove(long id);
}
