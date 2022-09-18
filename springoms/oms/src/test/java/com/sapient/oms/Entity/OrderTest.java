package com.sapient.oms.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.oms.Enums.OrderStatus;

@SpringBootTest
public class OrderTest {

    private static final OrderStatus PLACED = null;
    private Order order;
    private int id;
    private float price;
    private OrderStatus orderStatus;

    @Test
    @BeforeEach
    void init() {

        id = 5;
        price = 200;
        orderStatus = PLACED;
        order = new Order(id, price,orderStatus);

    }

    @Test
    void testGetId() {
        int expectedId = order.getId();
        Assertions.assertEquals(expectedId, order.getId());
    }

    @Test
    void testGetPrice() {
        float expectedPrice = order.getPrice();
        Assertions.assertEquals(expectedPrice, order.getPrice());
    }
    @Test
    void testGetOrderStatus() {
        OrderStatus expectedOrderStatus = order.getOrderStatus();
        Assertions.assertEquals(expectedOrderStatus, order.getOrderStatus());
    }

}