package com.sapient.oms.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.sapient.oms.Entity.Customer;
import com.sapient.oms.Entity.Order;
import com.sapient.oms.Repository.CustomerRepository;
import com.sapient.oms.Service.CustomerService;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;

    private Customer expectedCustomer;

    @BeforeEach
    void init() {
        expectedCustomer = new Customer();
        expectedCustomer.setCustomerId(9);
        expectedCustomer.setCustomerName("Priya");
        expectedCustomer.setEmail("priya@gmail.com");
        expectedCustomer.setPassword("123@abc");
        expectedCustomer.setOrder(new ArrayList<Order>());
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer(9, "Priya", "123@abc", "priya@gmail.com",new ArrayList<Order>());
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer actualCustomer = customerService.save(customer);
        assertEquals(expectedCustomer.toString(), actualCustomer.toString());
    }
}