package com.student.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.Entity.Student;
import com.student.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository stuRepos;

    @Autowired
    public StudentService(StudentRepository stuRepos) {
        this.stuRepos = stuRepos;
    }

    public List<Student> getAllStu() {
        return stuRepos.findAll();
    }

    public Optional<Student> getStuById(Long id) {
        return stuRepos.findById(id);
    }

    public Student addStu(Student student) {
        return stuRepos.save(student);
    }

    public Student updateStu(Student student) {
        return stuRepos.save(student);
    }

    public void deleteStu(Long id) {
        stuRepos.deleteById(id);
    }
}

