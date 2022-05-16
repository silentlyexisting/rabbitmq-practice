package com.silentlyexisting.practice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    @OneToOne(cascade = CascadeType.ALL)
    private College college;

    public Student(String firstName, String lastName, String city, College college) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.college = college;
    }
}
