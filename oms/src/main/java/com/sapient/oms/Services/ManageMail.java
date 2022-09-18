package com.sapient.oms.Services;

import com.sapient.oms.entity.Customer;

public class ManageMail {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Shalini", "password", "shalini.sa2k@gmail.com");

        Email mail = new Email();
        String recipient = customer.getEmail();
        mail.sendmail(recipient,customer);
    }
}