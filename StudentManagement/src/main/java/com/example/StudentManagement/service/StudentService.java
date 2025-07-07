package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }


    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }

    public Student getStudentById(int id){
        return studentRepo.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }
}