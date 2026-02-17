package com.klu.service.Implementation;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.klu.service.StudentService;
import com.klu.model.Student;

@Service
public class StudentServiceImplementation implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    // Welcome message
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student MVC CRUD";
    }

    // CREATE student
    @Override
    public Student createStudent(Student student) {
        studentList.add(student);
        return student;
    }

    // READ student by ID
    @Override
    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // READ all students
    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    // UPDATE student
    @Override
    public Student updateStudent(int id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                student.setId(id);
                studentList.set(i, student);
                return student;
            }
        }
        return null;
    }

    // DELETE student
    @Override
    public String deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                return "Student record removed successfully";
            }
        }
        return "Student not found";
    }
}
