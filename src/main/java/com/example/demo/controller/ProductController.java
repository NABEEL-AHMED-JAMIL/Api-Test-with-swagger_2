package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.productservice.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController implements IProductController{

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @Override
    public Iterable<Product> list(Model model) throws Exception {
        Iterable productList = productService.listAllProducts();
        return productList;
    }

    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @Override
    public Product showProduct(@PathVariable Long id, Model model) throws Exception {
        Product product = productService.getProductById(id);
        return product;
    }

    @ApiOperation(value = "Add a product")
    @Override
    public ResponseEntity saveProduct(@RequestBody Product product) throws Exception {
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a product")
    @Override
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @Override
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
