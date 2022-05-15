package com.silentlyexisting.practice.model;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private College college;
}
