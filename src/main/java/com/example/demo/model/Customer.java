package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by Nabeel on 9/26/2017.
 */
// generate the "get/set has-code,equal also the constructor of arg..."
@Data
//
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @NotNull
    @Column(name = "firstName")
    @ApiModelProperty(notes = "The give us firstName of Cutomer like 'firstName'")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    @ApiModelProperty(notes = "The give us lastName of Customer like 'Ahmed'")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="{invalid.email}")
    @ApiModelProperty(notes = "The give us valid email like 'nabeel.amd93@gmail.com'", required = true)
    private String email;

    @Column(name = "mobilePhone", nullable = false)
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
    @ApiModelProperty(notes = "The give us mobile-Phone like '(315)-381-7177'", required = true)
    private String mobilePhone;

    @Column(name = "homePhone", nullable = false)
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
    @ApiModelProperty(notes = "The give us home-Phone like '(315)-381-7177'")
    private String homePhone;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @ApiModelProperty(notes = "The will only support only the past data not the feture date")
    private Date birthday;

}
