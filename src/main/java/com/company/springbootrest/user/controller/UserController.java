package com.company.springbootrest.user.controller;

import com.company.springbootrest.user.model.User;
import com.company.springbootrest.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable final Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody final User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable final Integer id, @RequestBody final User user) {
        user.setId(id);
        userService.update(user);
    }
}
