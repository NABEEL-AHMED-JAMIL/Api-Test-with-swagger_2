package com.example.demo.service.userservice;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    private User userWithEmail;
    private User userWithLastName;

    @Override
    public User saveUser(final User user) { return userRepository.saveAndFlush(user); }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public User findOne(final Long id) { return userRepository.findOne(id); }

    @Override
    public User findByEmail(final String email) throws NullPointerException {
        userWithEmail = userRepository.findByEmail(email);
        if(!(userWithEmail.equals(null))){
            return userWithEmail;
        }
        throw new NullPointerException("Null Pointer Exception");
    }

    @Override
    public User findByName(final String lastName) throws NullPointerException {
        userWithLastName = userRepository.findByLastName(lastName);
        if(!(userWithLastName.equals(null))){
            return userWithLastName;
        }
        throw new NullPointerException("Null Pointer Exception");
    }


}
