package com.klu.demo.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.demo.Model.CourseRegistration;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseRegistration cr = (CourseRegistration) context.getBean("courseReg");
        cr.display();
    }
}