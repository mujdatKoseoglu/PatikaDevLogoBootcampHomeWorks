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
    //customername'e göre bulma
    @GetMapping("/{customername}")
    public Customer getByNameCustomer(@PathVariable String customername){
        return customerService.getByNameCustomer(customername);
    }
    //güncelleme
    @PutMapping("/{customername}")
    public Customer updateCustomer(@PathVariable("customername") String customername, @RequestBody Customer customer){
        return customerService.updateCustomer(customername,customer);
    }
    //silme
    @DeleteMapping("/{customername}")
    public Customer deleteCustomer(@PathVariable String customername){
        return customerService.deleteCustomer(customername);
    }
    //aktif ve masif duruma göre değişiklik yapma
    @PutMapping("/change-status/{name}/{bool}")
    public Customer changeState(@PathVariable String name, @PathVariable Boolean bool){
        return customerService.changeState(name,bool);
    }
    //aktif ve pasif duruma göre müşteri listesini getirme
    @GetMapping("/get-by-status/{status}")
    public List<Customer> getByStatus(@PathVariable Boolean status){
        return customerService.getByStatus(status);
    }
    @GetMapping
    public List<Customer> getByAllCustomer(){
        return customerService.getByAllCustomer();
    }


}
