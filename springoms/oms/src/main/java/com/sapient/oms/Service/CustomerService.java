package com.sapient.oms.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sapient.oms.Entity.Customer;
import com.sapient.oms.Repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getValue() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findByCustomerName(String name) {
        return customerRepository.findByCustomerName(name).get(0);
    }

    
    
}