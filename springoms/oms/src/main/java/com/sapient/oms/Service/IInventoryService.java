package com.sapient.oms.Service;
import java.util.List;

import com.sapient.oms.Entity.Inventory;

public interface IInventoryService {
    String updateQuantity(Integer storeId,Integer productId,int quantity);

    List<Inventory> findAll();

    List<Inventory> findByStoreId(Integer storeId);
}