package com.sapient.oms.entity;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class productTest{
    private Product product;
    private int productId;
     private String title;
     private float price;
     private Date mfg;
     private Date exp;

     
    @Test
    @BeforeEach
    void init(){
               
        productId = 6000;
        title = "Chocolates" ;
        price =  50;
        mfg = new Date();
        exp = new Date();
        //Date mfg_date = new Date();
		//Date exp_date = new Date();
        product = new Product(productId, title, price, mfg, exp);  
    }

    @Test
    void testproductId(){
        int expectedProductId = product.getProductId();
        Assertions.assertEquals(expectedProductId , this.productId);  
    }
    @Test
    void testtitle(){
        String expectedTitle = product.getTitle();
        Assertions.assertEquals(expectedTitle , this.title);  
    }
    @Test
    void testprice(){
        float expectedPrice = product.getPrice();
        Assertions.assertEquals(expectedPrice , this.price);  
    }
    @Test
    void testmfg(){
        Date expectedmfg = product.getMfg();
        Assertions.assertEquals(expectedmfg , this.mfg); 
    }
    @Test
    void testexp(){
        Date expectedexp = product.getExp();
        Assertions.assertEquals(expectedexp , this.exp);  
    }
}