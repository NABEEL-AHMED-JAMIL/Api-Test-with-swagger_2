package com.example.demo.controller.customercontroller;

import com.example.demo.controller.AbstractRestHandler;
import com.example.demo.model.Customer;
import com.example.demo.service.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<Iterable<Customer>> list(Model model) {
        return new ResponseEntity(this.customerService.listAllCustomers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> findByEmail(@PathVariable String email) {
        System.out.println("email:" + email);
        return new ResponseEntity(this.customerService.findByEmail(email), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(this.customerService.saveCustomer(customer), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        // issue method
        return new ResponseEntity(this.customerService.saveCustomer(customer), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return null;
    }
}
