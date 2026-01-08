package com.example.demo_spring_mvc.controller;

import com.example.demo_spring_mvc.model.Customer;
import com.example.demo_spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")

    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customerList = customerService.getAll();
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/customers/detail")
    public ModelAndView showDetail(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("customers/detail");
        Customer customer = customerService.findById(id);
        System.out.println(customer);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
}
