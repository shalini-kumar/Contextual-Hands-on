package com.sapient.oms.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sapient.oms.Entity.Order;
import com.sapient.oms.Enums.OrderStatus;
import com.sapient.oms.Exceptions.OrderNotFoundException;
import com.sapient.oms.Repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getValue() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    
    public Order findById(Integer id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null)
            throw new OrderNotFoundException("order id=" + id);
        return order;
    }

    public List<Order> findByOrderStatus(OrderStatus orderStatus) {
        List<Order> allOrders = getValue();
        List<Order> result = new ArrayList<>();
        for (Order order : allOrders) {
            if (order.getOrderStatus() == orderStatus) {
                result.add(order);
            }
        }
        return result;
    }
}