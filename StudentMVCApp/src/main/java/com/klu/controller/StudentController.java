package com.klu.controller;

import java.util.List;   // CORRECT import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.service.StudentService;
import com.klu.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;
 
    // welcome
    @GetMapping("/greet")
    public String getWelcomeMessage() {
        return service.getWelcomeMessage();
    }
 
    // create
    @PostMapping("/students/add")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // get all students
    @GetMapping("/students/getall")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // get student by id
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // update student
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // delete student
    @DeleteMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
