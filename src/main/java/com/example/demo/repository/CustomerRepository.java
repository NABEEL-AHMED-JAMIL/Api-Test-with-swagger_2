package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    String FIND_BY_EMAIL = "SELECT o FROM Customer o WHERE o.email = :email";
    @Query(FIND_BY_EMAIL)
    Customer findByEmail(@Param("email") String email);

    Customer findByUsername( String username );
}
