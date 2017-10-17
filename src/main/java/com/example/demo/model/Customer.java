package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by Nabeel on 9/26/2017.
 */
// generate the "get/set has-code,equal also the constructor of arg..."
@Entity
@Table(name = "customer")
public class Customer {

    private final int MIN_RANGE = 8;
    private final int MAX_RANGE = 32;

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
    @Past // refer to the past value no the current and next value
    @ApiModelProperty(notes = "The will only support only the past data not the feture date")
    private Date birthday;

    @Range(min=MIN_RANGE,max=MAX_RANGE)
    @Column(name = "password", nullable = false)
    private String password;


    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", MAX_RANGE=" + MAX_RANGE + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' + ", homePhone='" + homePhone + '\'' +
                ", birthday=" + birthday + ", password='" + password + '\'' + '}';
    }
}