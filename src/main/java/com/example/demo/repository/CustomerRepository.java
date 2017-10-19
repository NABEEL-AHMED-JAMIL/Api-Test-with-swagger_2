package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    Customer findByEmail(String email);

    Customer findByUsername( String username );
}
