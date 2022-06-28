package business.abstracts;

import entity.Bill;

import java.util.List;

public interface BillService {
    public void add(String name, Bill bill);
    public void getAll();
    public List<Bill> findBill1biggerthen1500();
    public  double findBill1biggerthen1500avarage();
    public  List<String> findBill1lessthen500name();

}
