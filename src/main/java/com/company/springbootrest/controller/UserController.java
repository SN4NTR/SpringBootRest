package com.company.springbootrest.controller;

import com.company.springbootrest.entity.User;
import com.company.springbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void save(@RequestParam(name = "name") String name,
                     @RequestParam(name = "password") String password) {
        User user = new User(name, password);
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable int id,
                     @RequestParam(name = "name") String name,
                     @RequestParam(name = "password") String password) {
        userService.save(new User(id, name, password));
    }
}
