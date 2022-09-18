package com.sapient.oms.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreTest {
    private Store store;
    private int id;
    private String shopName;
    private String emailId;
    private int contactNumber;

    @BeforeEach
    void initialize() {

        id = 1;
        shopName = "Z enterprises";
        emailId = "Z@gmail.com";
        contactNumber = 12345678;
        store = new Store(id, shopName, contactNumber, emailId);
        }

    @Test
    void testGetId() {
        int expectedId = store.getId();
        Assertions.assertEquals(expectedId, store.getId());
    }

    @Test
    void testGetShopName() {
        String expectedName = store.getShopName();
        Assertions.assertEquals(expectedName, store.getShopName());
    }

    // @Test
    // void testGetlocation() {
    //     Location expectedlocation = store.getLocation();
    //     Assertions.assertEquals(expectedlocation, store.getLocation());
    // }

    @Test
    void testGetEmailId() {
        String expectedEmail = store.getEmailId();
        Assertions.assertEquals(expectedEmail, store.getEmailId());
    }

    @Test
    void testGetContactNumber() {
        int expectedContact = store.getContactNumber();
        Assertions.assertEquals(expectedContact, store.getContactNumber());
    }
}
