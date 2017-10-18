package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Nabeel on 9/26/2017.
 */

// need test to check either it give or not
public interface CustomerService {


    Customer findByEmail(String email);

    Iterable<Customer> listAllCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(Long id);

}
