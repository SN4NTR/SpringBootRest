package com.company.springbootrest.service;

import com.company.springbootrest.entity.Role;
import com.company.springbootrest.entity.User;
import com.company.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
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
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void edit(User user) {
        user.setRole(userRepository.getOne(user.getId()).getRole());
        user.setCreated(userRepository.getOne(user.getId()).getCreated());
        userRepository.save(user);
    }
}
