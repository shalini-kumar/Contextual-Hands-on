package com.sapient.oms.Services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.Entity.Inventory;
import com.sapient.oms.Entity.Store;
import com.sapient.oms.Repository.StoreRepository;
import com.sapient.oms.Service.StoreService;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {
    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreService storeService;

    private Store expectedStore;

    @BeforeEach
    void setup() {
        expectedStore = new Store();
        expectedStore.setId(10);
        expectedStore.setShopName("z enterprises");
        expectedStore.setContactNumber(12345678);
        expectedStore.setEmailId("zenterprises@gmail.com");
        expectedStore.setInventory(new HashSet<Inventory>());
    }

    @Test
    void testSaveStore() {
        Store store = new Store(10, "z enterprises", 12345678, "zenterprises@gmail.com", new HashSet<Inventory>());
        when(storeRepository.save(any(Store.class))).thenReturn(store);
        Store actualStore = storeService.save(store);
        assertEquals(expectedStore.toString(), actualStore.toString());
    }
    
}