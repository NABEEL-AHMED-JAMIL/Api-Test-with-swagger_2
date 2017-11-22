# Api-Test-with-swagger_2

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
cd Api-Test-with-swagger_2

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
 │   │   ├──com.example.demo
 │   │   │   ├──exception
 │   │   │   │   └── DataFormatException.java
 │   │   │   │   └── ResourceNotFoundException.java
 │   │   │   ├──config
 │   │   │   │   └── CachingConfig.java
 │   │   │   │   └──SecurityConfigurer.java             
 │   │   │   │   └──SwaggerConfig.java
 │   │   │   ├──model
 │   │   │   │   ├──Authority.java
 │   │   │   │   ├──CustomerTokenState.java             
 │   │   │   │   └──Product.java                        
 │   │   │   │   └──Customer.java
 │   │   │   │   └──RestErrorInfo.java
 │   │   │   ├──repository                              
 │   │   │   │   └──ProductRepository.java
 │   │   │   │   └──CustomerRepository.java
 │   │   │   ├──controller                                            * rest endpoint folder
 │   │   │   │   ├──AbstractRestHandler.java
 │   │   │   │   ├──AuthenticationController.java
 │   │   │   │   ├──CustomerController.java
 │   │   │   │   ├──ICustomerController.java
 │   │   │   │   ├──IProductController.java
 │   │   │   │   ├──ProductController.java
 │   │   │   ├──security                                        
 │   │   │   │   ├──auth
 │   │   │   │   │   ├──JwtAuthenticationRequest.java           
 │   │   │   │   │   ├──LogoutSuccess.java                      
 │   │   │   │   │   ├──RestAuthenticationEntryPoint.java       
 │   │   │   │   │   ├──TokenAuthenticationFilter.java          
 │   │   │   │   │   └──TokenBasedAuthentication.java           
 │   │   │   │   └──TokenHelper.java                            
 │   │   │   ├──service
 │   │   │   │   ├──customerservice
 │   │   │   │   │   ├──CustomerService.java          
 │   │   │   │   │   └──CustomerServiceImpl.java
 │   │   │   │   ├──fetchservice
 │   │   │   │   │   └──FileFetchService.java
 │   │   │   │   ├──productservice
 │   │   │   │   │   ├─ProductService.java          
 │   │   │   │   │   └──ProductServiceImpl.java
 │   │   │   │   └──UserService.java
 │   │   │   └──Application.java                          
 │   │   └──recources
 │   │       ├──application.yml                          
 │   │       └──application.properties
 │   │       └──import.sql
 │   │       └──ehcache.xml
 │   │       └──banner.txt                               
 │   └──test                                             
 └──pom.xml                                              
```

### Configuration
- **SecurityConfigurer.java**: The server-side authentication configurations.
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

## Check the demo for Swagger-Ui
http://localhost:8080/swagger-ui.html for Check the out-put check the screen shot in screen-shot folder in project
