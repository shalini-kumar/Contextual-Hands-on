package com.sapient.oms.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.Inventory;
import com.sapient.oms.Entity.InventoryId;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findById(InventoryId inventoryId);

    List<Inventory> findByIdStoreId(Integer storeId);
    
}
