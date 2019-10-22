package com.company.springbootrest.service;

import com.company.springbootrest.entity.User;
import com.company.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        user.setCreated(new Date(new java.util.Date().getTime()));
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void edit(User user) {
        user.setCreated(userRepository.getOne(user.getId()).getCreated());
        userRepository.save(user);
    }
}
