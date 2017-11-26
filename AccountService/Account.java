package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Domain object for an employee.
 *
 * @author Greg Turnquist
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

  private @Id @GeneratedValue Long id;
  private final String userName, password, role;

  Account() {
    this.userName = null;
    this.password = null;
    this.role = null;
  }

  public Account(String firstName, String lastName, String title) {
    this.userName = firstName;
    this.password = lastName;
    this.role = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getRole() {
    return role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account employee = (Account) o;
    return Objects.equals(getId(), employee.getId()) &&
            Objects.equals(getUserName(), employee.getUserName()) &&
            Objects.equals(getPassword(), employee.getPassword()) &&
            Objects.equals(getRole(), employee.getRole());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUserName(), getPassword(), getRole());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Employee{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(userName).append('\'');
    sb.append(", lastName='").append(password).append('\'');
    sb.append(", title='").append(role).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
