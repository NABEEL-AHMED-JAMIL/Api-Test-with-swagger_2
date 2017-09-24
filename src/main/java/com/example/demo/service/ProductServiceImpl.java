package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() { return this.productRepository.findAll(); }

    @Override
    public Product getProductById(Long id) {
        return this.productRepository.findOne(id);
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.delete(id);
    }

}
