package com.sapient.oms.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {
    Location location;
    private int id;
    private String lineAddress;
    private String city;
    private String state;
    private String country;
    private int pincode;

    @Test
    @BeforeEach
    void init() {

        id = 21;
        lineAddress = "Veera Street";
        pincode = 600077;
        city = "Chennai";
        state = "TamilNadu";
        country = "India";
        location = new Location(id,  lineAddress,  pincode,  city,  state,  country);

    }

    @Test
    void testGetId() {
        int expectedId = location.getId();
        Assertions.assertEquals(expectedId, location.getId());
    }

    @Test
    void testGetlineAddress() {
        String expectedlineAddress = location.getLineAddress();
        Assertions.assertEquals(expectedlineAddress, location.getLineAddress());
    }

    @Test
    void testGetCity() {
        String expectedCity = location.getCity();
        Assertions.assertEquals(expectedCity, location.getCity());
    }

    @Test
    void testGetState() {
        String expectedState = location.getState();
        Assertions.assertEquals(expectedState, location.getState());
    }

    @Test
    void testGetCountry() {
        String expectedCountry = location.getCountry();
        Assertions.assertEquals(expectedCountry, location.getCountry());
    }

    @Test
    void testGetPincode() {
        int expectedPincode = location.getPincode();
        Assertions.assertEquals(expectedPincode, location.getPincode());
    }
}
