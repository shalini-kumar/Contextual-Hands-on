package com.sapient.oms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    
}