package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;
import java.util.List;

/**
 * Created by Nabeel on 9/26/2017.
 */

// need test to check either it give or not
public interface CustomerService {


    Customer findByEmail(String email) throws NullPointerException;

    List<Customer> listAllCustomers();

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer findByUsername( String username );

    void evictCache();


}
