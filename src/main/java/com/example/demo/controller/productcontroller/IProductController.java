package com.example.demo.controller.productcontroller;

import com.example.demo.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import static com.example.demo.util.RequestMapping.*;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public interface IProductController {


    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @Cacheable("products")
    @RequestMapping(value = LIST, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    Iterable<Product> list(io.swagger.models.Model model);

    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @Cacheable(value = "products", key = "#id")
    @RequestMapping(value = SHOW_PRODUCT, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    Product showProduct(@PathVariable Long id, Model model);

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = SAVE_PRODUCT, method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    ResponseEntity saveProduct(@RequestBody Product product);

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = UPDATE_PRODUCT, method = RequestMethod.PUT, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product);

    @ApiOperation(value = "Delete a product")
    @CacheEvict(value = "products", key = "#id")
    @RequestMapping(value= DELETE, method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    ResponseEntity delete(@PathVariable Long id);

}
