package com.example.demo_product.repository;

import com.example.demo_product.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
