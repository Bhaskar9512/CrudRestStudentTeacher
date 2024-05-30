package com.prog.restbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.restbook.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Teacher save(Teacher author);

	
}