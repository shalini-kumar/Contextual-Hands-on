package com.sapient.oms.entity;
import java.util.Date;
import java.util.Iterator;

public class Product {

     //static int product_id=0;

     private int productId;
     private String title;
     private float price;
     private Date mfg;
     private Date exp;
/* 
private void increment(){
    productId++;
}
*/

     
     public Product(int productId, String title, float price, Date mfg, Date exp)
      {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.mfg = mfg;
        this.exp = exp;
        
        
    }
 
    /*public Product(String title, float price, Date mfg, Date exp) 
    {
     this(Integer.toString(Product.productId),title,price,mfg,exp);
     increment();
   }
   */

@Override
public String toString() {
   
    return "[ Product Id:- "+this.productId+", Title:- "+this.title+",   PriceofProduct:-  "+this.price+", ManufacturedDate:- "+this.mfg+", ExpiryDate:- "+this.exp+" ]";
}

public int getProductId() {
    return productId;
}

public void setProductId(int productId) {
    this.productId = productId;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public float getPrice() {
    return price;
}

public void setPrice(float price) {
    this.price = price;
}

public Date getMfg() {
    return mfg;
}

public void setMfg(Date mfg) {
    this.mfg = mfg;
}

public Date getExp() {
    return exp;
}

public void setExp(Date exp) {
    this.exp = exp;
}

public static Iterator<Product> iterator() {
    return null;
}

}

