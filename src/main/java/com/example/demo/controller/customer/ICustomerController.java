package com.example.demo.controller.customer;

import com.example.demo.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

import static com.example.demo.util.RequestMapping.*;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Api(value="customer", description="Customer Operation handling")
public interface ICustomerController {

    @ApiOperation(value = "View a list of available customer",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @RequestMapping(value = CUSTOMER_LIST, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Iterator<Customer>> list();

    @ApiOperation(value = "Search with an Email", response = Customer.class)
    @RequestMapping(value = FIND_BY_EMAIL, method= RequestMethod.GET, produces = {"application/json", "application/xml"})
    ResponseEntity<Customer> findByEmail(@PathVariable String email);

    @ApiOperation(value = "New Customer Save")
    @RequestMapping(value = SAVE_CUSTOMER, method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer);

    @ApiOperation(value = "Customer Update..... Detail")
    @RequestMapping(value = UPDATE_CUSTOMER, method = RequestMethod.PUT, consumes = { "application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer);

    @ApiOperation(value = "Customer Delete....")
    @RequestMapping(value= DELETE_CUSTOMER, method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> deleteCustomer(@PathVariable Long id);

}
