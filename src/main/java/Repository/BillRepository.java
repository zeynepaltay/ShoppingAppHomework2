package Repository;

import Models.Bill;
import Models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javax.swing.UIManager.get;

@AllArgsConstructor
@Repository
public class BillRepository {

    List<Bill> billList = new ArrayList<Bill>();
    public List<Bill> getUsersBillsTotal(){
        List<Bill> juneBills = billList.stream()
                .filter(bill -> bill.getCustomer().getDateTime().getMonth() == Month.JUNE)
                .sorted((bill1, bill2) -> bill1.getCustomer().getName().compareTo(bill2.getCustomer().getName()))
                .collect(Collectors.toList());
        return juneBills;
    }

    public List<Bill> getAllBills(){
        return billList;
    }

    public List<Bill> min1500(){
        List<Bill> min1500=billList.stream()
                .filter(bill -> bill.getAmount()>1500)
                .collect(Collectors.toList());
        return min1500;
    }

    public List<Bill> max500(){
        List<Bill> max500= billList.stream()
                .filter(bill -> bill.getAmount()<500)
                .collect(Collectors.toList());
        return max500;
    }

    public List<Bill> juneAverage(){
        List<Bill> juneBills = billList.stream()
                .filter(bill -> bill.getDateTime().getMonth() == Month.JUNE)
                .sorted((bill1, bill2) -> bill1.getCustomer().getName().compareTo(bill2.getCustomer().getName()))
                .collect(Collectors.toList());
        return juneBills;

    }



}
