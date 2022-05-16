package com.silentlyexisting.practice.service;

import com.silentlyexisting.practice.dto.StudentDto;
import com.silentlyexisting.practice.model.College;
import com.silentlyexisting.practice.model.Student;
import com.silentlyexisting.practice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public Student createNewStudent(StudentDto studentDto) {
        return repository.save(new Student(
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getCity(),
                toCollege(studentDto)
        ));
    }

    private College toCollege(StudentDto studentDto) {
        return new College(
                studentDto.getCollege().getName(),
                studentDto.getCollege().getGrade(),
                studentDto.getCollege().getAttendance(),
                studentDto.getCollege().getSubjects()
        );
    }
}
