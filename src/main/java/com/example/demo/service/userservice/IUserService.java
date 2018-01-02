package com.example.demo.service.userservice;

import com.example.demo.model.User;
import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
public interface IUserService {

    public User saveUser(final User user);
    public List<User> findAll();
    public User findOne(final Long id);
    public User findByEmail(final String email) throws NullPointerException;
    public User findByName(final String lastName) throws NullPointerException;
}
