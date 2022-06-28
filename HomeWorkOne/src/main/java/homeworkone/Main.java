package homeworkone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService =new CustomerService();
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

        BillService billService=new BillService();
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
