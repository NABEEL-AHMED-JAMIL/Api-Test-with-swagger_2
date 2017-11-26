package com.example.demo.service.productservice;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Nabeel on 9/24/2017.
 */
// used the cache
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Ok method work
    @Override
    public List<Product> listAllProducts() {
        return this.productRepository.findAll();
    }

    // Ok method work
    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        Product product = this.productRepository.findOne(id);
        if(!(product.equals(null))){
            return product;
        }
        throw new NullPointerException("Null Pointer Exception");
    }

    @Override
    public void saveProduct(Product product) {
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



