package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
