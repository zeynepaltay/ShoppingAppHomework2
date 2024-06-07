package Service;

import Models.Bill;
import Models.Customer;
import Repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BillService {

    final BillRepository billRepository;

    public Map<Customer, Double> getUsersBillsTotal() {
        List<Bill> juneBills = billRepository.getUsersBillsTotal();
        Customer customer = juneBills.get(0).getCustomer();
        Map<Customer, Double> map = new HashMap<Customer, Double>();
        double sum = 0;
        for (int i = 0; i < juneBills.stream().count(); i++) {

            Bill bill = juneBills.get(i);
            if (customer != bill.getCustomer()) {

                map.put(customer, sum);
                sum = 0;
                customer = bill.getCustomer();
            }
            sum += bill.getAmount();
        }
        return map;
    }

    public List<Bill> getAllBills() {
        return billRepository.getAllBills();
    }

    public List<Bill> min1500() {
        return billRepository.min1500();
    }

    public Integer average1500() {
        List<Bill> min1500 = billRepository.min1500();
        int sum = 0;
        for (int i = 0; i < min1500.size(); i++) {
            sum += min1500.get(i).getAmount();
        }
        return sum / min1500.size();
    }

    public List<String> max500() {
        List<String> customerNames = billRepository.max500().stream().
                map(bill -> bill.getCustomer().getName()).collect(Collectors.toList());

        Set<String> customer = new HashSet<String>(customerNames);
        customerNames = new ArrayList<String>(customer);
        return customerNames;
    }

    public List<String> juneAverage() {
        List<Bill> juneBills = billRepository.juneAverage();
        Customer customer = juneBills.get(0).getCustomer();
        Map<Customer, Double> map = new HashMap<Customer, Double>();
        double sum = 0;
        int count = 0;
        for (int i = 0; i < juneBills.stream().count(); i++) {

            Bill bill = juneBills.get(i);
            if (customer != bill.getCustomer()) {
                double avg = sum / count;
                map.put(customer, avg);
                count = 0;
                sum = 0;
                customer = bill.getCustomer();
            }
            sum += bill.getAmount();
            count++;
        }
        List<String> sectors = map.entrySet().stream()
                .filter(entry -> entry.getValue() < 750)
                .map(entry -> entry.getKey().getSector())
                .collect(Collectors.toList());
        return sectors;
    }
}