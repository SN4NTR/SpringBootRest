package com.company.springbootrest.controller;

import com.company.springbootrest.entity.Role;
import com.company.springbootrest.entity.User;
import com.company.springbootrest.repository.UserRepository;
import com.company.springbootrest.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User();
        userService.save(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any());
        assertNotNull(user.getCreated());
        assertTrue(CoreMatchers.is(user.getRole()).matches(Role.ROLE_USER));
    }

    @Test
    void getById() {
        Mockito.when(userRepository.getOne(ArgumentMatchers.anyInt())).thenReturn(new User());

        User expectedUser = new User();
        User actualUser = userService.getById(ArgumentMatchers.anyInt());

        Mockito.verify(userRepository, Mockito.times(1)).getOne(ArgumentMatchers.anyInt());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void getAll() {
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(new User(), new User()));

        List<User> expectedList = Arrays.asList(new User(), new User());
        List<User> actualList = userService.getAll();

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
        assertEquals(expectedList, actualList);
    }

    @Test
    void delete() {
        Mockito.when(userRepository.getOne(ArgumentMatchers.anyInt())).thenReturn(new User());

        userService.delete(ArgumentMatchers.anyInt());
        Mockito.verify(userRepository, Mockito.times(1)).delete(new User());
    }
}