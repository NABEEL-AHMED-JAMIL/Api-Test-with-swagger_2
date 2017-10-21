package com.example.demo.service.productservice;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Nabeel on 9/24/2017.
 */
// used the cache
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() {
        System.out.println("Retrieving from Database");
        return this.productRepository.findAll();
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("Retrieving from Database");
        return this.productRepository.findOne(id);
    }

    @Override
    @CachePut(value = "products", key = "#product.id")
    public void saveProduct(Product product) {
        System.out.println("Retrieving from Database");
        this.productRepository.save(product);
    }

    @Override
    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        System.out.println("Deleting from Database");
        this.productRepository.delete(id);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void evictCache() {

    }

}
