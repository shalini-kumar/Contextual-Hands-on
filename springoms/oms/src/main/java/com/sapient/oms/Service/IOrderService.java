package com.sapient.oms.Service;
import java.util.List;
import com.sapient.oms.Entity.Order;

public interface IOrderService {
    List<Order> getValue();
    Order save(Order order);
    void delete(Integer id);
}