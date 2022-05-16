package com.silentlyexisting.practice.service;

import com.silentlyexisting.practice.dto.StudentDto;
import com.silentlyexisting.practice.model.Student;

public interface StudentService {

    Student createNewStudent(StudentDto studentDto);
}
