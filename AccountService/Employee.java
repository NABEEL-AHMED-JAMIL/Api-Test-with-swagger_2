package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * Domain object for an employee.
 *
 * @author Greg Turnquist
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

  private @Id @GeneratedValue Long id;
  private final String firstName, lastName, title;

  Employee() {
    this.firstName = null;
    this.lastName = null;
    this.title = null;
  }

  public Employee(String firstName, String lastName, String title) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(getId(), employee.getId()) &&
            Objects.equals(getFirstName(), employee.getFirstName()) &&
            Objects.equals(getLastName(), employee.getLastName()) &&
            Objects.equals(getTitle(), employee.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFirstName(), getLastName(), getTitle());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Employee{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", title='").append(title).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
