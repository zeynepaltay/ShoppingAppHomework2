package Controller;

import Models.Customer;
import Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {
    final CustomerService customerService;

    @GetMapping("/customerList")
    public List<Customer> customerList(Customer customer) {
        return customerService.getCustomerList();
    }
    @GetMapping("/newCustomer")
    public void newCustomer(Customer customer){
        customerService.newCustomer(customer);
    }
    @GetMapping("/customersWithC")
    public List<Customer> customerListWithC(){
        return customerService.CustomerWithC();
    }


}
