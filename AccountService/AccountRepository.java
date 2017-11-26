package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * This repository shows interface and method-level security. The entire repository requires ROLE_USER, while certain
 * operations require ROLE_ADMIN.
 *
 * @author Greg Turnquist
 * @author Oliver Gierke
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

  Account findByUserName(String userName);
}
