package com.example.demo.controller.customercontroller;

import com.example.demo.controller.AbstractRestHandler;
import com.example.demo.model.Customer;
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
public class CustomerController extends AbstractRestHandler implements ICustomerController {


    @Override
    public Iterable<Customer> list(Model model) {
        return null;
    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }


    @Override
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        return null;
    }


    @Override
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return null;
    }


    @Override
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        return null;
    }
}
