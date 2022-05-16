package com.silentlyexisting.practice.controller;

import com.silentlyexisting.practice.dto.StudentDto;
import com.silentlyexisting.practice.exception.CustomNotFoundException;
import com.silentlyexisting.practice.model.Student;
import com.silentlyexisting.practice.repository.StudentRepository;
import com.silentlyexisting.practice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    public final StudentRepository repository;

    @PostMapping
    public Student postStudent(@RequestBody StudentDto studentDto) {
        return service.createNewStudent(studentDto);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException(id));
    }


}
