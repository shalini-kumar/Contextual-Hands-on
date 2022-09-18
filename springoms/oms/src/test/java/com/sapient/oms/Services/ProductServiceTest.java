package com.sapient.oms.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.Entity.Inventory;
import com.sapient.oms.Entity.Product;
import com.sapient.oms.Exceptions.ProductNotFoundException;
import com.sapient.oms.Repository.ProductRepository;
import com.sapient.oms.Service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    private Product expectedProduct;

    @BeforeEach
    void setup() {
        expectedProduct = new Product();
        expectedProduct.setId(12);
        expectedProduct.setProductName("biscuit");
        expectedProduct.setCost(20);
        expectedProduct.setMdate(new Date());
        expectedProduct.setEdate(new Date());
        expectedProduct.setInventory(new HashSet<Inventory>());
    }

    @Test
    void testSaveProduct() {
        Product product = new Product(12, "biscuit", new Date(), new Date(), 20,new HashSet<Inventory>());
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product actualProduct = productService.save(product);
        assertEquals(actualProduct.toString(), expectedProduct.toString());
    }

    @Test
    void testFindProductByIdExists() {
        Product product = new Product(12, "biscuit", new Date(), new Date(), 20,new HashSet<Inventory>());
        Optional<Product> product1 = Optional.of(product);
        when(productRepository.findById(12)).thenReturn(product1);
        Product actualProduct = productService.findById(12);
        assertEquals(expectedProduct.toString(), actualProduct.toString());
    }

    @Test
    void testFindProductByIdDoesNotExist() {
        Optional<Product> product = Optional.empty();
        when(productRepository.findById(12)).thenReturn(product);
        assertThrows(ProductNotFoundException.class,() -> productService.findById(12));
    }

    @Test
    void testFindProductByNameExists() {
        Product product = new Product(12 ,"biscuit", new Date(), new Date(), 20,new HashSet<Inventory>());
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        Product actualProduct = productService.findByName("biscuit");
        assertEquals(expectedProduct.toString(), actualProduct.toString());
    }

    @Test
    void testFindProductByNameDoesNotExist() {
        Product product = new Product(12, "chocolate", new Date(), new Date(), 20,new HashSet<Inventory>());
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        assertThrows(ProductNotFoundException.class,() -> productService.findByName("biscuit"));
    }
}
