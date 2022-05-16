package com.silentlyexisting.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long grade;
    private Long attendance;
    @ElementCollection(targetClass = String.class)
    private List<String> subjects;

    public College(String name, Long grade, Long attendance, List<String> subjects) {
        this.name = name;
        this.grade = grade;
        this.attendance = attendance;
        this.subjects = subjects;
    }
}


