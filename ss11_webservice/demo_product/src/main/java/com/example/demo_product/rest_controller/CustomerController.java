package com.example.demo_product.rest_controller;


import com.example.demo_product.model.Customer;
import com.example.demo_product.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> showList(){
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable long id,
                                                       @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(name = "id") long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.NO_CONTENT);
    }
}
