package com.company.springbootrest.service;

import com.company.springbootrest.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(int id);

    User getById(int id);

    List<User> getAll();
}
