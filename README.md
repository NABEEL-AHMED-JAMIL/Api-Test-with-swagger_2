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
