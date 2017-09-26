package com.example.demo.controller;

import com.example.demo.model.Customer;
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
public interface ICustomerController {

    @RequestMapping(value = FIND_BY_EMAIL, method= RequestMethod.GET)
    Customer findByEmail(String email);

    @RequestMapping(value = CUSTOMER_LIST, method= RequestMethod.GET)
    Iterable<Customer> list(Model model) throws Exception;

    @RequestMapping(value = SAVE_CUSTOMER, method = RequestMethod.POST)
    ResponseEntity saveCustomer(@RequestBody Customer customer) throws Exception;

    @RequestMapping(value = UPDATE_CUSTOMER, method = RequestMethod.PUT)
    ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws Exception;

    @RequestMapping(value= DELETE_CUSTOMER, method = RequestMethod.DELETE)
    ResponseEntity deleteCustomer(@PathVariable Long id) throws Exception;

}
