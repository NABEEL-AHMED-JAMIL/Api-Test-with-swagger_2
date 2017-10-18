package com.example.demo.service.productservice;

import com.example.demo.model.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Nabeel on 9/24/2017.
 */
public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Long id);

    void saveProduct(Product product);

    void deleteProduct(Long id);

}
