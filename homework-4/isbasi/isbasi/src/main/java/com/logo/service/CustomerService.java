package com.logo.service;


import com.logo.Repository.CustomerRepository;

import com.logo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.logo.model.Customer;


@Service
public class CustomerService {

	/*@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;*/

	@Autowired
	private CustomerRepository customerRepository;

	//müşteri ekleme
	public Customer createCustomer(Customer customer) {

		return customerRepository.save(customer);
	}
	//güncelleme
	public Customer updateCustomer(Customer customer) {
		Customer customer1= customerRepository.findById(customer.getId()).get();
		customer1.setName(customer.getName());
		customer1.setAge(customer.getAge());
		customer1.setState(customer.getState());
		return customerRepository.save(customer1);
	}
	//müşteri silme
	public Customer deleteCustomer(Integer id) {

		Customer customer1 = customerRepository.findById(id).get();
		customerRepository.deleteById(id);
		System.out.println(id+" no lu id silindi");
		return customer1;
	}

}
