
import business.abstracts.BillService;
import business.abstracts.CustomerService;
import business.concretes.BillManager;
import business.concretes.CustomerManager;
import business.factories.BillFactory;
import business.factories.CustomerFactory;
import entity.Bill;
import entity.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CustomerFactory nesnemizi oluşturduk.
        CustomerFactory customerFactory = new CustomerFactory();
        //CustomerFactory nesnesi üzerinden polimorfizmi sağlayarak customerSeervice için oluşacak müşteri türünü belirledik.
        CustomerService customerService = customerFactory.createCustomer("müsteri");

        BillFactory billFactory = new BillFactory();
        BillService billService = billFactory.createBill("fatura");

        Customer customer1=new Customer("Halil","Yıldız",22,"erkek");
        Customer customer2=new Customer("Cemil","Kaplan",22,"erkek");
        Customer customer3=new Customer("Ceren","Aslan",22,"erkek");
        customerService.add(customer1);
        customerService.add(customer2);
        customerService.add(customer3);
        List<Customer> allByC = customerService.getAllByC();
        allByC.stream().forEach(k->{
            System.out.println(k);
        });


        Bill bill = new Bill(2000);
        Bill bill1 = new Bill(3000);
        Bill bill2 = new Bill(4500);
        Bill bill3 = new Bill(1400);
        billService.add("halil",bill);
        billService.add("mehmet",bill1);
        billService.add("ceren",bill2);
        billService.add("tugce",bill3);

        billService.getAll();
        billService.findBill1biggerthen1500().stream().forEach(k -> {
            System.out.println(k);
        });

        System.out.println(billService.findBill1biggerthen1500avarage());
        System.out.println(billService.findBill1lessthen500name());
    }
}