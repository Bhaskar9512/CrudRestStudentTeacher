package com.prog.restbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prog.restbook.factory.FactoryProvider;
import com.prog.restbook.model.Student;
import com.prog.restbook.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private FactoryProvider factoryProvider;


    @GetMapping("/Student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(id);
        student.setId(studentDetails.getId());
        student.setTitle(studentDetails.getTitle());
        return studentService.saveStudent(student);
    }
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        Student newStudent = (Student) factoryProvider.getFactory("Student").create("Student");
        newStudent.setId(student.getId());
        newStudent.setTitle(student.getTitle());
        return studentService.saveStudent(newStudent);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}