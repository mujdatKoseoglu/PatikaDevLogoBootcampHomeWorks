package business.abstracts;

import entity.Customer;

import java.util.List;

public interface CustomerService {
    public void add(Customer customer);
    public Customer updateName(String newName, String name);
    public void deleteCustomerByName(String name);
    public List<Customer> getAllByC();
    public void getALL();
}
