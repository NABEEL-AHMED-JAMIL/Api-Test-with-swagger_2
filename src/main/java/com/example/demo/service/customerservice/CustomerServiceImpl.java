package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Cacheable(value = "customers", key = "#email")
    public Customer findByEmail(String email) {
        System.out.println("email:" + email);
        // replace this by log
        System.out.println("Retrieving from Database");
        Customer customer = this.customerRepository.findByEmail(email);
        System.out.println(customer.toString());
        return customer;
    }

    @Override
    public Iterable<Customer> listAllCustomers() {
        System.out.println("Retrieving from Database");
        return this.customerRepository.findAll();
    }

    @Override
    @CachePut(value = "customers", key = "#customer.id")
    public Customer saveCustomer(Customer customer) {
        System.out.println("Retrieving from Database");
        return this.customerRepository.save(customer);
    }

    @Override
    @CacheEvict(value = "customers", key = "#email")
    public void deleteCustomer(Long id) {
        System.out.println("Deleting from Database and also cachce");
        this.customerRepository.delete(id);
    }

    @Override
    @Cacheable(value = "customers", key = "#username")
    public Customer findByUsername(String username) {
        System.out.println("Retrieving from Database");
        return this.customerRepository.findByUsername(username);

    }

    @Override
    @CacheEvict(value = "customers", allEntries = true)
    public void evictCache() {

    }
}
