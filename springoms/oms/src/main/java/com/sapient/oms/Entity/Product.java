package com.sapient.oms.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotBlank(message = "please provide product name here")
    private String productName;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date mdate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date edate;
    private double cost;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<Inventory> inventory = new ArrayList<Inventory>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<OrderItem> orderitems = new HashSet<OrderItem>();

    public Product(int productId, String productName, Date mdate, Date edate, double cost, Collection<Inventory> inventory) {
        this.productId = productId;
        this.productName = productName;
        this.mdate = mdate;
        this.edate = edate;
        this.cost = cost;
        this.inventory = inventory;
    }

    public Product() {
    }

    public Product(int id2, String productName2, Date mdate2, Date edate2, double cost2) {
    }

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double d) {
        this.cost = d;
    }

    

    public void setInventory(Collection<Inventory> inventory) {
        this.inventory = inventory;
    }

   

    public void setOrderitems(Set<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ Product Id:- " + this.productId);
        strBuilder.append(", Title:- " + this.productName);
        strBuilder.append(", Price:-  " + this.cost);
        strBuilder.append(", Manufactured:- " + this.mdate);
        strBuilder.append(", Expiry:- " + this.edate + " ]");

        return strBuilder.toString();
    }

    public static Object getValue() {
        return null;
    }

    public Product orElse(Object object) {
        return null;
    }
}