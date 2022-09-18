package com.sapient.oms.Entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sapient.oms.Enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    
    @Column(name = "cost")
    private float price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderitems = new HashSet<OrderItem>();

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date orderedDate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date deliveryDate;

    public Order() {

    }

    // public Order(int orderId, Customer customer, float price, OrderStatus orderStatus) {
    //     this.orderId = orderId;
    //     this.customer = customer;
    //     this.price = price;
    //     this.orderStatus = orderStatus;
    // }
    

    public Order(int id2, float price2, OrderStatus orderStatus2) {
    }

    public Order(int orderId, Customer customer, float price, OrderStatus orderStatus, Set<OrderItem> orderitems,
            Date orderedDate, Date deliveryDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.price = price;
        this.orderStatus = orderStatus;
        this.orderitems = orderitems;
        this.orderedDate = orderedDate;
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + orderId;
        result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        return result;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (other.orderId==this.orderId)
        return true;
        return false;
    }

    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return orderId;
    }

    // public Customer getCustomer() {
    //     return customer;
    // }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", orderId=" + orderId + ", orderStatus=" + orderStatus + ", price=" + price + "]";
    }

    public Order orElse(Object object) {
        return null;
    }

    public Set<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

}