package com.example.demo.controller.customercontroller;

import com.example.demo.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.example.demo.util.RequestMapping.*;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Api(value="customer", description="Customer Operation handling")
public interface ICustomerController {

    @ApiOperation(value = "Search with an Email", response = Customer.class)
    @Cacheable(value = "customers", key = "#email")
    @RequestMapping(value = FIND_BY_EMAIL, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    Customer findByEmail(String email);

    @ApiOperation(value = "View a list of available customer",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @Cacheable("customers")
    @RequestMapping(value = CUSTOMER_LIST, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    Iterable<Customer> list(Model model);


    @ApiOperation(value = "New Customer Save")
    @RequestMapping(value = SAVE_CUSTOMER, method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
        // remove from the cache
//    @CacheEvict(value = "employee", key = "#surname")
    ResponseEntity saveCustomer(@RequestBody Customer customer);

    @ApiOperation(value = "Customer Update..... Detail")
    @RequestMapping(value = UPDATE_CUSTOMER, method = RequestMethod.PUT, consumes = { "application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer);

    @ApiOperation(value = "Customer Delete....")
    @CacheEvict(value = "customers", key = "#id")
    @RequestMapping(value= DELETE_CUSTOMER, method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    ResponseEntity deleteCustomer(@PathVariable Long id);

}
