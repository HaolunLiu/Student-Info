package com.student.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.entity.Student;
import com.student.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository stuRepos;


    public List<Student> getAllStu(){
        return stuRepos.findAll();
    }

    public Student addStu(Student student){
        return stuRepos.save(student);
    }
    public Optional<Student> findById(Long id){
        return stuRepos.findById(id);
    }
    public Student updateStu(Long id, Student student){
        student.setId(id);
        return stuRepos.save(student);
    }

    public void deleteStu(Long id){
        stuRepos.deleteById(id);
    }

}

