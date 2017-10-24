package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

import static com.example.demo.util.RequestMapping.PRODUCT;

/**
 * Created by Nabeel on 9/24/2017.
 */
@RestController
@RequestMapping(PRODUCT)
public class ProductController extends AbstractRestHandler implements IProductController {

    @Autowired
    private ProductService productService;
    private Product product;
    // method work ok
    @Override
    public ResponseEntity<Iterator<Product>> list() {
        List<Product> productList = productService.listAllProducts();
        if(!productList.isEmpty()) {
            return new ResponseEntity(productList, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Empty List");
    }

    // method work ok
    @Override
    public ResponseEntity<Product> showProduct(@PathVariable Long id) {
        try {
            this.product = productService.getProductById(id);
            return new ResponseEntity(product, HttpStatus.OK);
        }catch (NullPointerException e) {
            throw new ResourceNotFoundException("Data Not Found");
        }

    }

    @Override
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product storedProduct = productService.getProductById(id);
        if(storedProduct.getId() != null) {
            storedProduct.setDescription(product.getDescription());
            storedProduct.setImageUrl(product.getImageUrl());
            storedProduct.setPrice(product.getPrice());
            productService.saveProduct(storedProduct);
            return new ResponseEntity("Product updated successfully", HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Data Not Found");

    }


    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
