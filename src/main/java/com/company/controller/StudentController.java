package com.company.controller;

import com.company.entity.Student;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public void save(@RequestParam(name = "name") String name) {
        studentService.save(name);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") int id) {
        return studentService.getById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        studentService.delete(id);
    }
}
