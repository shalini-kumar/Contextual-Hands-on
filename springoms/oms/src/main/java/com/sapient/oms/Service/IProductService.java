package com.sapient.oms.Service;
import java.util.List;

import com.sapient.oms.Entity.Product;

public interface IProductService {
    List<Product> getValue();
    Product save(Product product);
    void delete(Integer id);
    Product findById(Integer id);
    Product findByName(String name);
}
