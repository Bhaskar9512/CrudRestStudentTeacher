package com.prog.restbook.factory;


import org.springframework.stereotype.Component;

import com.prog.restbook.model.Student;
import com.prog.restbook.model.Teacher;

@Component
public class TeacherFactory implements AbstractFactory<Teacher> {
    @Override
    public Teacher create(String type) {
        if ("Book".equalsIgnoreCase(type)) {
            return new Teacher();
        }
        return null;
    }
}