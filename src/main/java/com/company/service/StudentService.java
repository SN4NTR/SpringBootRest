package com.company.service;

import com.company.entity.Student;

import java.util.List;

public interface StudentService {

    void save(String name);

    void delete(int id);

    Student getById(int id);

    List<Student> getAll();
}
