package com.sapient.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.Entity.Inventory;
import com.sapient.oms.Entity.InventoryId;
import com.sapient.oms.Exceptions.StoreNotFoundException;
import com.sapient.oms.Repository.InventoryRepository;


@Service
public class InventoryService implements IInventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    StoreService storeService;

    @Override
    public String updateQuantity(Integer storeId, Integer productId, int quantity) {
        InventoryId inventoryId = new InventoryId(storeId.intValue(), productId.intValue());
        Inventory inventory = inventoryRepository.findById(inventoryId).orElse(null);
        if (inventory == null) {
            return "Product not found in the store";
        }
        inventory.setQuantity(quantity);
        inventoryRepository.save(inventory);
        return "Product updated with quantity " + quantity;
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories;
    }

    @Override
    public List<Inventory> findByStoreId(Integer storeId) throws StoreNotFoundException{
        storeService.findById(storeId);
        List<Inventory> inventories = inventoryRepository.findByIdStoreId(storeId);
        return inventories;
    }

    public Inventory addNewProduct(Inventory inventory) {
        return null;
    }

    public List<Inventory> getProductById(Integer id) {
        return null;
    }
}