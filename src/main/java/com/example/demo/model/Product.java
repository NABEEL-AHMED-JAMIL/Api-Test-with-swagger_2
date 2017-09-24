package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @Version
    @Column(name = "version")
    @ApiModelProperty(notes = "The auto-generated version of the product")
    private Integer version;

    @Column(name = "productId")
    @ApiModelProperty(notes = "The application-specific product ID")
    private String productId;

    @Column(name = "description")
    @ApiModelProperty(notes = "The product description")
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imageUrl")
    @ApiModelProperty(notes = "The image URL of the product")
    private String imageUrl;

    @Column(name = "price")
    @ApiModelProperty(notes = "The price of the product", required = true)
    private BigDecimal price;

    public Product() { }

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +  "id=" + id + ", version=" + version + ", productId='" + productId + '\'' +
                ", description='" + description + '\'' + ", imageUrl='" + imageUrl + '\'' + ", price=" + price + '}';
    }

}
