package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @Override
    public List<Customer> listAllCustomers() {
       return this.customerRepository.findAll();
    }

    @Override
    @Cacheable(value = "customers", key = "#email")
    public Customer findByEmail(String email) {
        System.out.println("Retrieving from Database");
         customer = this.customerRepository.findByEmail(email);
        if(!(customer.equals(null))){
            return customer;
        }
        throw new NullPointerException("Null Pointer Exception");
    }

    @Override
    @CachePut(value = "customers", key = "#customer.id")
    public Customer saveCustomer(Customer customer) {
        System.out.println("Retrieving from Database");
        return this.customerRepository.save(customer);
    }

    @Override
    @CacheEvict(value = "customers", key = "#id")
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
