package com.silentlyexisting.practice.model;

import lombok.Data;

import java.util.List;

@Data
public class College {
    private String name;
    private Long grade;
    private Long attendance;
    private List<String> subjects;
}
