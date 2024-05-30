package com.prog.restbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.restbook.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student save(Student book);
}