package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
/**
 * Created by Nabeel on 1/2/2018.
 */
@Entity
public class User extends AbstractPersistable {

    private String firstName;
    private String lastName;
    @Pattern(regexp = ".{1,255}@.{1,255}")
    @NotNull(message = "Value may not be empty")
    @Column(unique = true)
    private String email;
    private Date birthday;

    public User() {}
    public User(final Long id) { super.setId(id); }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' + ", birthday=" + birthday + '}';
    }
}
