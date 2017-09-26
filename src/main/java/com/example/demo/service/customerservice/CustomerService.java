package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Nabeel on 9/26/2017.
 */
public interface CustomerService {

    Customer findByEmail(String email) throws EntityNotFoundException;

    Iterable<Customer> listAllCustomers();

    void saveCustomer(Customer customer) throws EntityNotFoundException;

    void deleteCustomer(Long id);

}
