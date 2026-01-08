package com.example.demo_spring_mvc.service;

import com.example.demo_spring_mvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class CustomerService implements ICustomerService{
    private static Map<Integer,Customer> customerList;

    static {
        customerList = new HashMap<>();
        customerList.put(1,new Customer(1,"Huy"));
        customerList.put(2,new Customer(2,"Minh"));
        customerList.put(3,new Customer(3,"Hạo"));
    }


    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }
}
