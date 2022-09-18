package com.sapient.oms.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.oms.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    List<Customer> findByCustomerName(String name);

}