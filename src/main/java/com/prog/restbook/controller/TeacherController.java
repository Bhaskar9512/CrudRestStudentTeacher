package com.prog.restbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prog.restbook.factory.FactoryProvider;
import com.prog.restbook.model.Teacher;
import com.prog.restbook.service.TeacherService;

import java.util.List;

@RestController

public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FactoryProvider factoryProvider;

    @PostMapping("/Teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = (Teacher) factoryProvider.getFactory("Teacher").create("Teacher");
        newTeacher.setName(teacher.getName());
        newTeacher.setId(teacher.getId());
        return teacherService.saveTeacher(newTeacher);
    }

    @GetMapping("/Teacher")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/Teacher/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacher.setName(teacherDetails.getName());
        teacher.setId(teacherDetails.getId());
        return teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}