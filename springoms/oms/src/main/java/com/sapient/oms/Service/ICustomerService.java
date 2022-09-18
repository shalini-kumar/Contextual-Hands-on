package com.sapient.oms.Service;
import java.util.List;
import com.sapient.oms.Entity.Customer;

public interface ICustomerService {
    List<Customer> getValue();
    Customer save(Customer customer);
    void delete(Integer id);
    Customer findByCustomerName(String name);

}