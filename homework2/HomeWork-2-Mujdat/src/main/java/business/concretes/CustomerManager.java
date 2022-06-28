package business.concretes;

import business.abstracts.CustomerService;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerManager implements CustomerService {
    private final List<Customer> customerServiceList =new ArrayList<Customer>();

    public void add(Customer customer){//eklemek için
        customerServiceList.add(customer);
    }
    public Customer updateName(String newName, String name){//güncelleme yapmak için

        int i = customerServiceList.stream()
                .map(customer -> customer.getName())
                .collect(Collectors.toList())
                .indexOf(name);
        Customer customer = customerServiceList.get(i);
        customer.setName(newName);
        customerServiceList.set(i, customer);
        return customer;
    }
    public void deleteCustomerByName(String name){ //silmek için
        int index = customerServiceList.stream()
                .map(customerService -> customerService.getName())
                .collect(Collectors.toList())
                .indexOf(name);
        customerServiceList.remove(index);
    }
    public List<Customer> getAllByC(){//C ile başlayanları getir  // todo refactor metod name
        return customerServiceList.stream()
                .filter(customerService -> customerService.getName().contains("C"))
                .collect(Collectors.toList());
    }
    public void getALL(){//hepsini getir
        customerServiceList.stream()
                .forEach(k->{System.out.print(k);});

    }

}
