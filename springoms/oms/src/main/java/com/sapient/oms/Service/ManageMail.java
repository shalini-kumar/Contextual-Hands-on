package com.sapient.oms.Service;

import java.util.ArrayList;

import com.sapient.oms.Entity.Customer;
import com.sapient.oms.Entity.Order;

public class ManageMail {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Shalini", "password", "shalini.sa2k@gmail.com",new ArrayList<Order>());

        EmailService mail = new EmailService();
        String recipient = customer.getEmail();
        mail.sendmail(recipient,customer);
    }
}