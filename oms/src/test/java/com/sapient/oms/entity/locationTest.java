package com.sapient.oms.entity;
import org.junit.jupiter.api.Assertions;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class locationTest {
        private Location location;
        private int LocationId;
        private String streetAddress;
        private String city;
        private String state;
        private String country;
        private int pincode;
        
        
        @Test
        @BeforeEach
        void init(){
            LocationId = 10;
            streetAddress = "Chocolates" ;
            city = "Chennai";
            state = "Tamilnadu";
            country = "India";
            pincode = 600077;
            location = new Location(LocationId,streetAddress,city,state,country,pincode);  
        }
        @Test
        void getDoorNumber(){
            int expectedLocationId = location.getLocationId();
            Assertions.assertEquals(expectedLocationId, this.LocationId);
        }
        @Test
        void streetAddress(){
            String expectedStreetAddress = location.getStreetAddress();
            Assertions.assertEquals(expectedStreetAddress, this.streetAddress);
        }
        @Test
        void getCity(){
            String expectedCity = location.getCity();
            Assertions.assertEquals(expectedCity, this.city);
        }
        @Test
        void getState(){
            String expectedState = location.getState();
            Assertions.assertEquals(expectedState, this.state);
        }
        @Test
        void getCountry(){
            String expectedCountry = location.getCountry();
            Assertions.assertEquals(expectedCountry, this.country);
        }
        @Test
        void getPincode(){
            int expectedPincode = location.getPincode();
            Assertions.assertEquals(expectedPincode, this.pincode);
        }

    
}