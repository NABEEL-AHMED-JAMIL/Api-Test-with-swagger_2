package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Domain object for an item managed by the company.
 *
 * @author Greg Turnquist
 * @author Oliver Gierke
 */
@Entity
public class Item {

  private @Id @GeneratedValue Long id;
  private final String description;

  Item() {
    this.description = null;
  }

  public Item(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(getId(), item.getId()) &&
            Objects.equals(getDescription(), item.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDescription());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Item{");
    sb.append("id=").append(id);
    sb.append(", description='").append(description).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
