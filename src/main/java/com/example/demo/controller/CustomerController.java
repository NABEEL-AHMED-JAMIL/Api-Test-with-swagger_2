package com.example.demo.controller;

import com.example.demo.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.demo.util.RequestMapping.CUSTOMER;

/**
 * Created by Nabeel on 9/26/2017.
 */
@RestController
@RequestMapping(CUSTOMER)
@Api(value="customer", description="Customer Operation handling")
public class CustomerController implements ICustomerController{

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @Override
    public Iterable<Customer> list(Model model) throws Exception {
        return null;
    }


    @ApiOperation(value = "Search with an Email", response = Customer.class)
    @Override
    public Customer findByEmail(String email) {
        return null;
    }

    @ApiOperation(value = "New Customer Save")
    @Override
    public ResponseEntity saveCustomer(@RequestBody Customer customer) throws Exception {
        return null;
    }

    @ApiOperation(value = "Customer Update..... Detail")
    @Override
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws Exception {
        return null;
    }

    @ApiOperation(value = "Customer Delete....")
    @Override
    public ResponseEntity deleteCustomer(@PathVariable Long id) throws Exception {
        return null;
    }
}
