package com.company.springbootrest.user.repository;

import com.company.springbootrest.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(@NotNull final String email);
}
