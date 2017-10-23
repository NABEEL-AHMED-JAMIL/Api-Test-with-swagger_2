package com.example.demo.service.productservice;

import com.example.demo.model.Product;
import java.util.List;

/**
 * Created by Nabeel on 9/24/2017.
 */
public interface ProductService {


    List<Product> listAllProducts();

    Product getProductById(Long id) throws NullPointerException;

    void saveProduct(Product product);

    void deleteProduct(Long id);

    void evictCache();

}
