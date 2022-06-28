package homeworkone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BillService {

     HashMap<String,Bill> billMap = new HashMap<String,Bill>();

     public void add(String name,Bill bill){
         billMap.put(name,bill);
     }//ekleme
     public void getAll(){//hepsini getir
         billMap.entrySet().stream()
                 .forEach(k->{
                     System.out.println("İsim :" +k.getKey() + "Price : "  + k.getValue().getPrice());
                 });
     }
     public  List<Bill> findBill1biggerthen1500(){//1500 den büyük için
         return billMap.entrySet().stream()
                 .filter(k -> k.getValue().getPrice() > 1500)
                 .map(k -> k.getValue())
                 .collect(Collectors.toList());

     }

    public  double findBill1biggerthen1500avarage(){//1500 den büyük ortalama için
         return billMap.entrySet().stream()
                .filter(k -> k.getValue().getPrice() > 1500)
                 .mapToInt(a-> a.getValue().getPrice())
                 .average()
                 .getAsDouble(); // optional için
    }
    public  List<String> findBill1lessthen500name(){//500 den küçük
        return billMap.entrySet().stream()
                .filter(k -> k.getValue().getPrice() < 500)
                .map(k -> k.getKey())
                .collect(Collectors.toList());

    }

}
