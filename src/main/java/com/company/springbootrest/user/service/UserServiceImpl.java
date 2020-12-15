package com.company.springbootrest.user.service;

import com.company.springbootrest.user.model.User;
import com.company.springbootrest.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

import static com.company.springbootrest.user.model.Role.ROLE_USER;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(@NotNull final Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByEmail(@NotNull final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(@NotNull final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(ROLE_USER);
        user.setCreated(new Date(new java.util.Date().getTime()));
        userRepository.save(user);
    }

    @Override
    public void delete(@NotNull final Integer id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public void update(@NotNull final User user) {
        user.setRole(userRepository.getOne(user.getId()).getRole());
        user.setCreated(userRepository.getOne(user.getId()).getCreated());
        userRepository.save(user);
    }
}
