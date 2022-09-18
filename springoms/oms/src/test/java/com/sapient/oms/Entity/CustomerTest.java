package com.sapient.oms.Entity;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {
    private Customer customer;
    private int customerId;
    private String customerName;
    private String password;
    private String email;

    @Test
    @BeforeEach
    void init() {

        customerId = 9;
        customerName = "Priya";
        password = "123@abc";
        email = "priya@gmail.com";
        customer = new Customer(customerId,customerName,password,email,new ArrayList<Order>());

    }

    @Test
    void testGetCustomerId() {
        int expectedId = customer.getCustomerId();
        Assertions.assertEquals(expectedId, customer.getCustomerId());
    }

    @Test
    void testGetCustomerName() {
        String expectedName = customer.getCustomerName();
        Assertions.assertEquals(expectedName, customer.getCustomerName());
    }

    @Test
    void testGetPassword() {
        String expectedpassword = customer.getPassword();
        Assertions.assertEquals(expectedpassword, customer.getPassword());
    }

    @Test
    void testGetEmail() {
        String expectedEmail = customer.getEmail();
        Assertions.assertEquals(expectedEmail, customer.getEmail());
    }
}
