// package com.sapient.oms.Services;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.sapient.oms.Entity.Customer;
// import com.sapient.oms.Entity.Order;
// import com.sapient.oms.Enums.OrderStatus;
// import com.sapient.oms.Exceptions.OrderNotFoundException;
// import com.sapient.oms.Repository.OrderRepository;
// import com.sapient.oms.Service.OrderService;

// @ExtendWith(MockitoExtension.class)
// public class OrderServiceTest {
//     @Mock
//     OrderRepository orderRepository;

//     @InjectMocks
//     OrderService orderService;

//     private Order expectedOrder;

//     @BeforeEach
//     void setup() {
//         expectedOrder = new Order();
//         expectedOrder.setId(10);
//         expectedOrder.setPrice(400);
//         expectedOrder.setOrderStatus(OrderStatus.PLACED);
//         expectedOrder.setCustomer(new Customer());
//     }

//     @Test
//     void testSaveOrder() {
//         Order order = new Order(10,new Customer(),400,OrderStatus.PLACED, null, null, null);
//         when(orderRepository.save(any(Order.class))).thenReturn(order);
//         Order actualOrder = orderService.save(order);
//         assertEquals(expectedOrder.toString(), actualOrder.toString());
//     }

//     // @Test
//     // void testfindByIdExists() {
//     //     Order order = new Order(10, new Customer(),400, OrderStatus.PLACED, null, null, null);
//     //     Optional<Order> order1 = Optional.of(order);
//     //     when(orderRepository.findById(10)).thenReturn(order1);
//     //     Order actualorder = orderService.findById(10).orElse(null);
//     //     assertEquals(expectedOrder.toString(), actualorder.toString());
//     // }

//     @Test
//     void testFindByIdDoesNotExist() {
//         Optional<Order> order = Optional.empty();
//         when(orderRepository.findById(10)).thenReturn(order);
//         assertThrows(OrderNotFoundException.class,() -> orderService.findById(10));

//     }
// }