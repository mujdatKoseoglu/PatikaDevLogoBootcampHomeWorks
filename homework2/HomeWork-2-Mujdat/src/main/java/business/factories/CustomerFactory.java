package business.factories;

import business.abstracts.CustomerService;
import business.concretes.CustomerManager;
import entity.Customer;

public class CustomerFactory {
    public CustomerService createCustomer(String customerType)
    {
        if (customerType == null || customerType.isEmpty())
            return null;
        switch (customerType) {
            case "müsteri":
                return new CustomerManager();
            default:
                throw new IllegalArgumentException("customerType error"+customerType);
        }
    }
}
