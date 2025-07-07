package com.example.StudentManagement.controller;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController{

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String allStudent(Model model){

        //Left side: "students"
        //This is the key or attribute name.
        //It will be used in the HTML view to refer to the data.

        //model.addAttribute(...)
        //This method is used to pass data from the Controller to the View.

        model.addAttribute("students",studentService.getStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudent(Model model){

        //addAttribute() to pass data from the controller to the view (HTML template).
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student); //student is sent to create_student.html, and its value is student.
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){ //Used to bind form data to a model object (usually in POST requests like form submissions).

        studentService.saveStudent(student);
        return "redirect:/students"; //Redirects to /students to show the updated list.
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}")
        public String updateStudent(@PathVariable int id, @ModelAttribute("student")Student student,Model model){
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }
}