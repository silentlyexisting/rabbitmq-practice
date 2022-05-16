package com.silentlyexisting.practice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CollegeDto {

    private String name;
    private Long grade;
    private Long attendance;
    private List<String> subjects;

}
