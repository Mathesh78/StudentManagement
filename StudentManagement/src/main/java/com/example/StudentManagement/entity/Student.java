package com.example.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

//Model :
//Manages the application's data, which can come from a database, API, or JSON object.

//View :
//Presents the model's data in a specific format, such as HTML, XML, video, or music.

//Controller :
//Manages user input, responds to it, and performs actions on the model's data

@Entity
@Data
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Student(){

    }
}