package com.sapient.oms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.oms.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}