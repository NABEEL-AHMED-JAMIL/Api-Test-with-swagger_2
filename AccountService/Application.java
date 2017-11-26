
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

/**
 * This example shows various ways to secure Spring Data REST applications using Spring Security
 *
 * @author Greg Turnquist
 */
@SpringBootApplication
public class Application {

  @Autowired ItemRepository itemRepository;
  @Autowired EmployeeRepository employeeRepository;
  @Autowired AccountRepository accountRepository;


    public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

  /**
   * Pre-load the system with employees and items.
   */
  public @PostConstruct void init() {

    employeeRepository.save(new Employee("Bilbo", "Baggins", "thief"));
    employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer"));
    employeeRepository.save(new Employee("Gandalf", "the Wizard", "servant of the Secret Fire"));

      accountRepository.save(new Account("majid", bCryptPasswordEncoder().encode("password"), "ROLE_ADMIN"));
      accountRepository.save(new Account("nabeel", bCryptPasswordEncoder().encode("password"), "ROLE_ADMIN"));
      accountRepository.save(new Account("123", bCryptPasswordEncoder().encode("password"), "ROLE_USER"));
      accountRepository.save(new Account("12", bCryptPasswordEncoder().encode("password"), "ROLE_USER"));


      /**
       * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
       * with an authentication token containing the necessary privileges.
       */
    SecurityUtils.runAs("system", "system", "ROLE_ADMIN");

    itemRepository.save(new Item("Sting"));
    itemRepository.save(new Item("the one ring"));



    SecurityContextHolder.clearContext();
  }

  /**
   * This application is secured at both the URL level for some parts, and the method level for other parts. The URL
   * security is shown inside this code, while method-level annotations are enabled at by
   * {@link EnableGlobalMethodSecurity}.
   *
   * @author Greg Turnquist
   * @author Oliver Gierke
   */
  @Configuration
  @EnableGlobalMethodSecurity(prePostEnabled = true)
  @EnableWebSecurity
  static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
      @Autowired
      private UserDetailsService userDetailsService;
      @Autowired
      BCryptPasswordEncoder bCryptPasswordEncoder;

     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.httpBasic().and().authorizeRequests().//
              antMatchers(HttpMethod.POST, "/employees").hasRole("ROLE_ADMIN").//
              antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ROLE_ADMIN").//
              antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ROLE_ADMIN").and().//
              antMatchers(HttpMethod.GET, "/**").hasRole("ROLE_DOCTER").and().//

              csrf().disable();
    }
  }
}


