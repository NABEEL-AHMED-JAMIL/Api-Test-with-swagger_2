package com.example.demo.controller.user;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



/**
 * Created by Nabeel on 1/2/2018.
 */
public interface IUserController {

    public List<User> fetchAll();
    public User fetchById(@PathVariable("id") final Long id);
    public User getByLastName(@RequestParam("lastName") final String lastName);
}
