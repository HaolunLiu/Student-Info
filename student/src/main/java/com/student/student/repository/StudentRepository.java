package com.student.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA provides CRUD methods out-of-the-box
}