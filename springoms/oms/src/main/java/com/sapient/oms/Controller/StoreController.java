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

import com.sapient.oms.Entity.Inventory;
import com.sapient.oms.Entity.Store;
import com.sapient.oms.Exceptions.StoreNotFoundException;
import com.sapient.oms.Service.StoreService;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping
    List<Store> getStores() {
        return storeService.getValue();
    }

    @GetMapping("/ALL")
    String getALLstores() {
        return storeService.getValue().toString();

    }

    @GetMapping("/id/{id}")
    public Store findById(@PathVariable("id") Integer id){
       try{
        Store store = storeService.findById(id);
        return store;
       }
       catch(StoreNotFoundException e){
        System.out.println(e.getMessage());
        return new Store();
       }
    }
    @PostMapping
    void save(@Valid @RequestBody Store store) {
        storeService.save(store);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) {
        storeService.delete(id);
    }
    @GetMapping("/product/{store}")
    Collection<Inventory> getProducts(@PathVariable("store") Integer storeId) {
            try{
                return storeService.findById(storeId).getInventory();
            }catch(Exception e){
                System.out.println(e.getMessage());
                return new ArrayList<Inventory>();
            }

    }
}