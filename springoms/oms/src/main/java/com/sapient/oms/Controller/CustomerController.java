package com.sapient.oms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.oms.Entity.Customer;
import com.sapient.oms.Service.CustomerService;
import java.util.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getValue();
    }

    @PostMapping
    void save(@Valid @RequestBody Customer customer) {
        customerService.save(customer);
    }
    
    @GetMapping("/{customername}")
    Customer getCustomer(@PathVariable("customername") String name) {
        return customerService.findByCustomerName(name);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) {
        customerService.delete(id);
    }
}