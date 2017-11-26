package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * This repository has no method-level security annotations. That's because it's secured at the URL level inside
 * {@link example.springdata.rest.security.SecurityConfiguration}.
 *
 * @author Greg Turnquist
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
