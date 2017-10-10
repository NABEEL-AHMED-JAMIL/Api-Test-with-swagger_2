package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.productservice.ProductService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.demo.util.RequestMapping.PRODUCT;

/**
 * Created by Nabeel on 9/24/2017.
 */
@RestController
@RequestMapping(PRODUCT)
public class ProductController implements IProductController{

    @Autowired
    private ProductService productService;

    @Override
    public Iterable<Product> list(Model model) throws Exception {
        Iterable productList = productService.listAllProducts();
        return productList;
    }

    @Override
    public Product showProduct(@PathVariable Long id, Model model) throws Exception {
        Product product = productService.getProductById(id);
        return product;
    }

    @Override
    public ResponseEntity saveProduct(@RequestBody Product product) throws Exception {
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }


    @Override
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }


    @Override
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
