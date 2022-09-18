package com.sapient.oms.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.oms.Entity.Product;
import com.sapient.oms.Exceptions.ProductNotFoundException;
import com.sapient.oms.Service.ProductService;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    List<Product> getProducts(){
        return productService.getValue();
    }
    
    @GetMapping("/ALL")
    List<Product> getALLproducts() {
        return productService.getValue();

    }

    @GetMapping("/id/{id}")
    public Product findById(@PathVariable("id") Integer id){
       try{
        Product product = productService.findById(id);
        return product;
       }
       catch(ProductNotFoundException e){
        System.out.println(e.getMessage());
        return new Product();
       }
    }

    @GetMapping("/name/{name}")
    Product findByName(@PathVariable("name") String name) {
        try{
            Product product = productService.findByName(name);
            return product;
        }
        catch(ProductNotFoundException e){
            System.out.println(e.getMessage());
            return new Product();     
        }
    }

    @PostMapping
    void save(@Valid @RequestBody Product product){
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

}