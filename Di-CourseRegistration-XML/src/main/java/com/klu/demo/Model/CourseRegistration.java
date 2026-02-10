package com.klu.demo.Model;

public class CourseRegistration {
    private int id;
    private String name;
    private String courseName;
    private int sem;
    
    // Constructor - must match the XML constructor-args
    public CourseRegistration(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    // Setter for sem - THIS IS CRITICAL
    public void setSem(int sem) {
        this.sem = sem;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getSem() {
        return sem;
    }
    
    // Display method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course Name: " + courseName);
        System.out.println("Semester: " + sem);
    }
}