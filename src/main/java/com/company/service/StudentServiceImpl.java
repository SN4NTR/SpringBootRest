package com.company.service;

import com.company.entity.Student;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(String name) {
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(studentRepository.getOne(id));
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
