package com.sapient.oms.entity;

import java.util.Date;

public class Order {
    private int id;
    private int deliveryAddress_id;
    private float totalAmount;
    private Date ordered_Date;
    private Date delivery_Date;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDeliveryAddress_id() {
        return deliveryAddress_id;
    }
    public void setDeliveryAddress_id(int deliveryAddress_id) {
        this.deliveryAddress_id = deliveryAddress_id;
    }
    public float getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Date getOrdered_Date() {
        return ordered_Date;
    }
    public void setOrdered_Date(Date ordered_Date) {
        this.ordered_Date = ordered_Date;
    }
    public Date getDelivery_Date() {
        return delivery_Date;
    }
    public void setDelivery_Date(Date delivery_Date) {
        this.delivery_Date = delivery_Date;
    }
    
}