package com.sapient.oms.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sapient.oms.Entity.Product;
import com.sapient.oms.Exceptions.ProductNotFoundException;
import com.sapient.oms.Repository.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getValue() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product findById(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null)
            throw new ProductNotFoundException("product id = " + id + " not found!!");
        return product;
    }

    public Product findByName(String name) throws ProductNotFoundException {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        throw new ProductNotFoundException("product = " + name + " not found!!");
    }
}