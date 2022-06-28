package business.factories;

import business.abstracts.BillService;
import business.abstracts.CustomerService;
import business.concretes.BillManager;
import business.concretes.CustomerManager;
import entity.Bill;

public class BillFactory {
    public BillService createBill(String billType)
    {
        if (billType == null || billType.isEmpty())
            return null;
        switch (billType) {
            case "fatura":
                return new BillManager();
            default:
                throw new IllegalArgumentException("billType error"+billType);
        }
    }
}
