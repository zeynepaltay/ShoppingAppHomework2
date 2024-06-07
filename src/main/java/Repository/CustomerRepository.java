package Repository;

import Models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class CustomerRepository {

    List<Customer> customerList = new ArrayList<Customer>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void newCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> CustomerWithC(){
        return customerList.stream().filter(customer -> customer.getName().contains("C") || customer.getName().contains("c")).collect(Collectors.toList());
    }

}
