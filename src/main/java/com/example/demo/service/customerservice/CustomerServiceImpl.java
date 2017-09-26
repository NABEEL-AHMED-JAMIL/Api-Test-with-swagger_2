package com.example.demo.service.customerservice;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @Override
    public Customer findByEmail(String email) throws EntityNotFoundException {
        this.customer= customerRepository.findByEmail(email);
        if(this.customer.equals(null)){
//            throw new EntityNotFoundException(Customer.class, "email", email);
        }
        return this.customer;
    }

    @Override
    public Iterable<Customer> listAllCustomers() {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) throws EntityNotFoundException {

    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
