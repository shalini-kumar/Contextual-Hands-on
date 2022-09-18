package com.sapient.oms.entity;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class storeTest {

    private Store store;
    private int storeId;
    private String storeName;
    private String owner;
    private int contact;
    //private int locationId;
    /**
     *  The init function replicates a store from database, hence it has all the fields as hard-coded
     */
    
    @Test
    @BeforeEach
    void init(){
               
        storeId = 1;
        storeName = "Silk Haul" ;
        owner =  "Anu";
        contact = 1;
        //locationId = 1;
        //Date mfg_date = new Date();
		//Date exp_date = new Date();
        store = new Store(storeId, storeName, owner, contact);
    }

    @Test
    void testGetStoreId(){
 
        int expectedStoreId = store.getStoreId();
        Assertions.assertEquals(expectedStoreId , this.storeId);  

    }

    @Test
    void testGetstoreName() {
    
        String expectedstoreName = store.getStoreName();
        Assertions.assertEquals(expectedstoreName , this.storeName);  
    }
    
    @Test
    void testGetOwner() {
    
        String expectedOwner = store.getOwner();
        Assertions.assertEquals(expectedOwner , this.owner );  
    }

    @Test
    void testGetContact() {
    
        int expectedContact = store.getContact();
        Assertions.assertEquals(expectedContact , this.contact);
        
    }

/* 
    @Test
    void testGetLocationId() {
    
        int  expectedLocationId =  store.getLocation();
        Assertions.assertEquals(expectedLocationId  , this.locationId);
        
    }
    */


        
    }
    