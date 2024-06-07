package Service;

import Models.Customer;
import Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CustomerService {
    final CustomerRepository customerRepository;
    public List<Customer> getCustomerList(){
        return customerRepository.getCustomerList();
    }
    public void newCustomer(Customer customer){
        customerRepository.newCustomer(customer);
    }
    public List<Customer> CustomerWithC(){
        return customerRepository.CustomerWithC();
    }


}
