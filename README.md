```
  ____            _   _   _         _     _            _
 |  _ \          | | | | (_)       | |   (_)          (_)
 | |_) |   __ _  | | | |  _   ___  | |_   _    ___     _   _ __     ___
 |  _ <   / _` | | | | | | | / __| | __| | |  / __|   | | | '_ \   / __|
 | |_) | | (_| | | | | | | | \__ \ | |_  | | | (__    | | | | | | | (__   _
 |____/   \__,_| |_| |_| |_| |___/  \__| |_|  \___|   |_| |_| |_|  \___| (_)
```

<p align="center">
    <img width="800" alt="Springboot JWT Starter" src="https://github.com/NABEEL-AHMED-JAMIL/Api-Test-with-swagger_2/blob/master/screen-shot/Screenshot%20(430).png">
</p>


```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone --depth 1 https://github.com/NABEEL-AHMED-JAMIL/Api-Test-with-swagger_2
# change directory to our repo
cd springboot-jwt-starter

# install the repo with mvn
mvn install

# start the server
mvn spring-boot:run

# the app will be running on port 8080
# there are two built-in user accounts to demonstrate the differing levels of access to the endpoints:
# - User - user:123
# - Admin - admin:123
```


### File Structure
```
springboot-jwt-starter/
 ├──src/                                                        * our source files
 │   ├──main
 │   │   ├──java.com.bfwg
 │   │   │   ├──config
 │   │   │   │   └──WebSecurityConfig.java                      * config file for filter, custom userSerivce etc.
 │   │   │   ├──model
 │   │   │   │   ├──Authority.java
 │   │   │   │   ├──UserTokenState.java                         * JWT model
 │   │   │   │   └──User.java                                   * our main User model.
 │   │   │   ├──repository                                      * repositories folder for accessing database
 │   │   │   │   └──UserRepository.java
 │   │   │   ├──rest                                            * rest endpoint folder
 │   │   │   │   ├──AuthenticationController.java               * auth related REST controller, refresh token endpoint etc.
 │   │   │   │   └──UserController.java                         * REST controller to handle User related requests
 │   │   │   ├──security                                        * Security related folder(JWT, filters)
 │   │   │   │   ├──auth
 │   │   │   │   │   ├──JwtAuthenticationRequest.java           * login request object, contains username and password
 │   │   │   │   │   ├──LogoutSuccess.java                      * controls the behavior after sign out.
 │   │   │   │   │   ├──RestAuthenticationEntryPoint.java       * handle auth exceptions, like invalid token etc.
 │   │   │   │   │   ├──TokenAuthenticationFilter.java          * the JWT token filter, configured in WebSecurityConfig
 │   │   │   │   │   └──TokenBasedAuthentication.java           * this is our custom Authentication class and it extends AbstractAuthenticationToken.
 │   │   │   │   └──TokenHelper.java                             * token helper class
 │   │   │   ├──service
 │   │   │   │   ├──impl
 │   │   │   │   │   ├──CustomUserDetailsService.java           * custom UserDatilsService implementataion, tells formLogin() where to check username/password
 │   │   │   │   │   └──UserServiceImpl.java
 │   │   │   │   └──UserService.java
 │   │   │   └──Application.java                                * Application main enterance
 │   │   └──recources
 │   │       ├──static                                          * static assets are served here(Angular and html templates)
 │   │       ├──application.yml                                 * application variables are configured here
 │   │       └──import.sql                                      * h2 database query(table creation)
 │   └──test                                                    * Junit test folder
 └──pom.xml                                                     * what maven uses to manage it's dependencies
```

### Configuration
- **WebSecurityConfig.java**: The server-side authentication configurations.
- **application.yml**: Application level properties i.e the token expire time, token secret etc. You can find a reference of all application properties [here](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html).
- **JWT token TTL**: JWT Tokens are configured to expire after 10 minutes, you can get a new token by signing in again.
- **Using a different database**: This Starter kit is using an embedded H2 database that is automatically configured by Spring Boot. If you want to connect to another database you have to specify the connection in the *application.yml* in the resource directory. Here is an example for a MySQL DB:

```
spring:
  jpa:
    hibernate:
      # possible values: validate | update | create | create-drop
      ddl-auto: create-drop
  datasource:
    url: jdbc:mysql://localhost/myDatabase
    username: myUser
    password: myPassword
    driver-class-name: com.mysql.jdbc.Driver
```

*Hint: For other databases like MySQL sequences don't work for ID generation. So you have to change the GenerationType in the entity beans to 'AUTO' or 'IDENTITY'.*

### JSON Web Token
> JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.
for more info, checkout https://jwt.io/

___

# Api-Test-with-swagger_2
Testing Api Using the Swagger-2
## Check the demo for Swagger-Ui
http://localhost:8080/swagger-ui.html for Check the out-put check the screen shot in screen-shot folder in project
### Project Structure
<h3>Model:-</h3>
<ul>
  <li>1:= Customer</li>
  <ul>
    <li>:= private Long id;</li>
    <li>:= private String firstName;</li>
    <li>:= private String lastName;</li>
    <li>:= private String email;</li>
    <li>:= private Date birthday;</li>
    <li>:= private String homePhone;</li>
    <li>  := private String password;</li>
  </ul>
  <li>2:= Product</li>
  <ul>
    <li>:= private Long id;</li>
    <li>:= private Integer version;</li>
    <li>:= private String productId;</li>
    <li>:= private String description;</li>
    <li>:= private String imageUrl;</li>
    <li>:= private BigDecimal price;</li>
  </ul>
</ul>
<h3>Repository:-</h3>
<ul>
  <li>1  CustomerRepository</li>
  <li>2  ProductRepository</li>
</ul>
<h3>Service:-</h3>
<ul>
  <li>1  CustomerService -----Implement-------> CustomerServiceImpl</li>
  <li>2  ProductService  -----Implement------> ProductServiceImpl</li>
</ul>
<h3>Security:-</h3>
    .....still working
