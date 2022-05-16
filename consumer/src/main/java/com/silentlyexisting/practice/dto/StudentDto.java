package com.silentlyexisting.practice.dto;

import lombok.Data;

@Data
public class StudentDto {

    private String firstName;
    private String lastName;
    private String city;
    private CollegeDto college;

}
