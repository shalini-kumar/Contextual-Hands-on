package com.sapient.oms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.oms.Entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
    
}