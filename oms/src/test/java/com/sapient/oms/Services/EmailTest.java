package com.sapient.oms.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.oms.entity.Customer;

@SpringBootApplication
public class EmailTest {

    private Email email;
    Customer customer = new Customer(1, "Shalini", "password", "shalini.sa2k@gmail.com");
    String reciever = customer.getEmail();

    @BeforeEach
    void setup() {
        email = new Email();

    }
    @Test
    void testEmail(){
        assertEquals("shalini.sa2k@gmail.com", reciever);
    }
    @Test
    void testmail() {
        String checkMail = email.sendmail(reciever, customer);
        assertEquals("Mail successfully sent", checkMail);
    }
}