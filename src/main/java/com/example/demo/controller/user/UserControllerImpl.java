package com.example.demo.controller.user;

import com.example.demo.model.User;
import com.example.demo.service.userservice.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserControllerImpl implements IUserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> fetchAll() {
        LOG.debug("Getting all users");
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User fetchById(@PathVariable("id") final Long id) {
        LOG.debug("Get user {}", id);
        return userService.findOne(id);
    }

    // using an alternative path is not HATEOAS-compliant
    @RequestMapping(params = "lastName", method = RequestMethod.GET)
    public User getByLastName(@RequestParam("lastName") final String lastName) {
        LOG.debug("Get user by last name {}", lastName);
        return userService.findByName(lastName);
    }

}
