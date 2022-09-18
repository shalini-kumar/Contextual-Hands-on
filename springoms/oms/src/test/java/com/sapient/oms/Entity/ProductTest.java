package com.sapient.oms.Entity;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    private Product product;
    private int id;
    private String productName;
    private Date mdate;
    private Date edate;
    private double cost;
    //private Inventory inventory;

    @Test
    @BeforeEach
    void init() {

        id = 3;
        productName = "Chocolates";
        mdate = new Date();
        edate = new Date();
        cost = 100;
        //inventory = new Inventory();
        //product = new Product(id, productName, mdate, edate, cost,inventory);
        product = new Product(id, productName, mdate, edate, cost);

    }

    @Test
    void testGetId() {
        int expectedId = product.getId();
        Assertions.assertEquals(expectedId, product.getId());
    }

    @Test
    void testGetproductName() {
        String expectedName = product.getProductName();
        Assertions.assertEquals(expectedName, product.getProductName());
    }

    @Test
    void testGetmdate() {
        Date expectedmdate = product.getMdate();
        Assertions.assertEquals(expectedmdate, product.getMdate());
    }

    @Test
    void testGetedate() {
        Date expectededate = product.getEdate();
        Assertions.assertEquals(expectededate, product.getEdate());
    }

    @Test
    void testGetCost() {
        double expectedCost = product.getCost();
        Assertions.assertEquals(expectedCost, product.getCost());
    }
    // @Test
    // void testGetInventory(){
    //     Inventory expectedInventory = product.getInventory();
    //     Assertions.assertEquals(expectedInventory, product.getInventory());
    // }

}
