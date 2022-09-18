package com.sapient.oms.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapient.oms.Entity.Store;
import com.sapient.oms.Exceptions.StoreNotFoundException;
import com.sapient.oms.Repository.StoreRepository;

@Service
public class StoreService implements IStoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getValue() {
        return storeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

    public Store findById(Integer id) throws StoreNotFoundException {
        Store store = storeRepository.findById(id).orElse(null);
        if (store == null)
            throw new StoreNotFoundException("store id " + id + " not found");
        return store;
    }


}


