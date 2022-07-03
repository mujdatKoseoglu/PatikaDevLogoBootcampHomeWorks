package com.logo.controller;

import com.logo.model.Customer;
import com.logo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //ekleme
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){

        return customerService.createCustomer(customer);
    }

    //güncelleme
    @PutMapping("/{customer}")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    //silme
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }


}
