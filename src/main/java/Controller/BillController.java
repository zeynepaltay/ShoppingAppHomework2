package Controller;

import Models.Bill;
import Models.Customer;
import Service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("/api/v1/bills")
@RestController
public class BillController {
    final BillService billService;

    @GetMapping("/getusersbillstotal")
    public Map<Customer,Double> getUsersBillsTotal(){
        return billService.getUsersBillsTotal();
    }

    @GetMapping("/allbills")
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }
    @GetMapping("/min1500")
    public List<Bill> min1500(){
        return billService.min1500();
    }

    @GetMapping("/average1500")
    public Integer average1500(){
        return billService.average1500();
    }
    @GetMapping("/max500")
    public List<String> max500(){
        return billService.max500();
    }
    @GetMapping("juneAverage")
    public List<String> juneAverage() {
        return billService.juneAverage();
    }
}
