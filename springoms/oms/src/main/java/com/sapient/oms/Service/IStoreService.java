package com.sapient.oms.Service;
import java.util.List;

import com.sapient.oms.Entity.Store;

public interface IStoreService {
    List<Store> getValue();
    Store save(Store store);
    void delete(Integer id);
    Store findById(Integer id);
}