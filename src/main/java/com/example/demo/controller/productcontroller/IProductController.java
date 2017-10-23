package com.example.demo.controller.productcontroller;

import com.example.demo.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Iterator;
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
    @RequestMapping(value = LIST, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    ResponseEntity<Iterator<Product>> list();

    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = SHOW_PRODUCT, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    ResponseEntity<Product> showProduct(@PathVariable Long id);

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = SAVE_PRODUCT, method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Product> saveProduct(@RequestBody Product product);

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = UPDATE_PRODUCT, method = RequestMethod.PUT, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product);

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value= DELETE, method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> delete(@PathVariable Long id);

}
