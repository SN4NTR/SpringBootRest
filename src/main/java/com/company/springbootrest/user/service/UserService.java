package com.company.springbootrest.user.service;

import com.company.springbootrest.user.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(@NotNull final Integer id);

    User getByEmail(@NotNull final String email);

    void save(@NotNull final User user);

    void delete(@NotNull final Integer id);

    void update(@NotNull final User user);
}
