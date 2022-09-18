package com.sapient.oms.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Order;
import com.sapient.oms.Entity.OrderItem;
import com.sapient.oms.Enums.OrderStatus;
import com.sapient.oms.Exceptions.OrderNotFoundException;
import com.sapient.oms.Service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired // dependecny injection
    OrderService orderService;// never create object

    @GetMapping
    List<Order> getOrders() {
        return orderService.getValue();
    }

    @GetMapping("/ALL")
    List<Order> getALLorders() {
        return orderService.getValue();

    }

    @GetMapping("/id/{id}")
    public Order findById(@PathVariable("id") Integer id) {
        try {
            Order order = orderService.findById(id).orElse(null);
            return order;
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
            return new Order();
        }
    }

    
    @GetMapping("/item/{order}")
    Collection<OrderItem> getItems(@PathVariable("order") Integer orderId) {
            try{
                return orderService.findById(orderId).getOrderitems();
            }catch(Exception e){
                System.out.println(e.getMessage());
                return new ArrayList<OrderItem>();
            }
    }


    @PostMapping
    void save(@Valid @RequestBody Order order) {
        orderService.save(order);
    }

    @DeleteMapping("/id/{id}")
    void delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
    }

    @GetMapping("/orderStatus/{orderStatus}")
    public List<Order> findByOrderStatus(@PathVariable("orderStatus") OrderStatus orderStatus) {
        return orderService.findByOrderStatus(orderStatus);

    }

}