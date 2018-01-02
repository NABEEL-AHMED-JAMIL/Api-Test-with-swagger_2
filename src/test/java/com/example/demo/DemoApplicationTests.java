package com.example.demo;

import com.example.demo.model.CustomerTokenState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private CustomerTokenState customerTokenState;
    public static final String REST_SERVICE_URI = "http://localhost:8080";
    public RestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}
	//
	private RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	public class User {

	    private String username;
	    private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @Test
    @Order(value = 1)
	public void createAuthenticationToken() {
		// first get the rest template
        customerTokenState = getRestTemplate().postForObject(
                REST_SERVICE_URI+"/api/auth/login",new User("admin","123") ,CustomerTokenState.class);
        assertEquals(customerTokenState != null,  true);

	}

	@Test
    @Order(value = 2)
	public void refreshAuthenticationToken() {
	    customerTokenState = getRestTemplate().getForObject(
	            REST_SERVICE_URI+"/api/refresh", CustomerTokenState.class);
        assertEquals(customerTokenState != null,  true);
	}

	/* GET */
	@Test
    @Order(value = 4)
	public void listOfProduct() {


    }

	/* GET */
	@Test
    @Order(value = 3)
	public void showProduct() {}

	/* POST */
	@Test
    @Order(value = 5)
	public void saveProduct() {}

	/* PUT */
	@Test
    @Order(value = 6)
	public void updateProduct() {}

	/* DELETE */
	@Test
    @Order(value = 7)
	public void deleteProduct() {}

	@Test
    @Order(value = 8)
	public void listCustomer() {}

	@Test
    @Order(value = 9)
	public void findByEmail() {}

	@Test
    @Order(value = 10)
	public void saveCustomer() {}

	@Test
    @Order(value = 11)
	public void updateCustomer() {}

	@Test
    @Order(value = 12)
	public void deleteCustomer() {}

}
