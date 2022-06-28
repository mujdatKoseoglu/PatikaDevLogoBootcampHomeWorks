package com.logo.repository;

import com.logo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    //müşterilerimizi tutabileceğimiz bir liste oluşturduk
    static List<Customer> listCustomer=new ArrayList<>();
    //müşteri oluşturduğumuz metodumuz
    public Customer createCustomer(Customer customerRequest) {
        listCustomer.add(customerRequest);
        return customerRequest;
    }
    //isme göre müşterileri bulan metodumuz
    public Customer getByNameCustomer(String nameRequest) {
        return listCustomer.stream().filter(k->k.getName().equals(nameRequest)).findFirst().orElseThrow();

    }
    //müşteri güncelleme metodumuz
    public Customer updateCustomer(String nameRequest, Customer customer) {
        Customer customer1=listCustomer.stream().filter(k->k.getName().equals(nameRequest)).findFirst().orElseThrow();
        customer1.setAge(customer.getAge());
        customer1.setName(customer.getName());
        customer1.setOrderList(customer.getOrderList());
        return customer1;

    }
    //müşteri silme metodumuz
    public Customer deleteCustomer(String nameRequest) {
        Customer customer1=listCustomer.stream().filter(k->k.getName().equals(nameRequest)).findFirst().orElseThrow();
        listCustomer.remove(customer1);
        return customer1;
    }
    //müşterinin durum değişikliği aktif/pasif
    public Customer changeState(String name, Boolean bool) {
        Customer customer1=listCustomer.stream().filter(k->k.getName().equals(name)).findFirst().orElseThrow();
        customer1.setState(bool);
        return customer1;
    }
    //pasif ya da aktif müşteri listesini getirme
    public List<Customer> getByStatus(Boolean status) {
        return listCustomer.stream().filter(k->k.getState().equals(status)).collect(Collectors.toList());
    }
    //tüm müşterileirn listesini geri döndüren metodumuz
    public List<Customer> getByAllCustomer() {
        return listCustomer;
    }
}
