package com.sapient.oms.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orderItems")
public class OrderItem{
    @EmbeddedId
    OrderItemId orderItemId = new OrderItemId();

    @ManyToOne
    @MapsId("orderId") //This is the name of attr in OrderItemId class
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId") //This is the name of attr in InventoryId class
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItemId getId() {
        return orderItemId;
    }
    public void setId(OrderItemId orderItemId) {
        this.orderItemId = orderItemId;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "quantity")
    private int quantity;
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "cost")
    private int cost;
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}