package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Nabeel on 9/26/2017.
 */
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {

    @Transient
    private final int MIN_RANGE = 8;
    @Transient
    private final int MAX_RANGE = 32;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="{invalid.email}")
    @ApiModelProperty(notes = "The give us valid email like 'nabeel.amd93@gmail.com'", required = true)
    private String email;

    @Range(min=MIN_RANGE,max=MAX_RANGE)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_password_rest_date")
    private Timestamp lastPasswordRestDate;

    @NotNull
    @Column(name = "firstName")
    @ApiModelProperty(notes = "The give us firstName of Cutomer like 'firstName'")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    @ApiModelProperty(notes = "The give us lastName of Customer like 'Ahmed'")
    private String lastName;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Past // refer to the past value no the current and next value
    @ApiModelProperty(notes = "The will only support only the past data not the feture date")
    private Date birthday;

    @Column(name = "mobilePhone", nullable = false)
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
    @ApiModelProperty(notes = "The give us mobile-Phone like '(315)-381-7177'", required = true)
    private String mobilePhone;

    @Column(name = "homePhone", nullable = false)
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
    @ApiModelProperty(notes = "The give us home-Phone like '(315)-381-7177'")
    private String homePhone;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Override
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonIgnore
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonIgnore
    @Override
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Timestamp getLastPasswordRestDate() { return lastPasswordRestDate; }
    public void setLastPasswordRestDate(Timestamp lastPasswordRestDate) { this.lastPasswordRestDate = lastPasswordRestDate; }


    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName;}

    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authorities) { this.authorities = authorities; }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
