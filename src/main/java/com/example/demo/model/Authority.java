package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Nabeel on 10/19/2017.
 */
@Entity
@Table(name="authority")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    String name;


    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() { return getName(); }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

}
