package com.prog.restbook.service;

import com.prog.restbook.factory.AbstractFactory;
import com.prog.restbook.factory.FactoryProvider;
import com.prog.restbook.model.Teacher;
import com.prog.restbook.model.Student;
import com.prog.restbook.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private FactoryProvider factoryprovider;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}