package com.prog.restbook.factory;

import org.springframework.stereotype.Component;

import com.prog.restbook.model.Student;
import com.prog.restbook.model.Teacher;
@Component
public class StudentFactory implements AbstractFactory<Student> {
    @Override
    public Student create(String type) {
        if ("Author".equalsIgnoreCase(type)) {
            return new Student();
        }
        return null;
    }
}