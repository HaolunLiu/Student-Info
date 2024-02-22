package com.student.student.controller;

import com.student.student.entity.Student;
import com.student.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService stuSer;

    @GetMapping("/students")
    public String list(Model model){
        model.addAttribute("students", stuSer.getAllStu());
        return "students";
    }

    @GetMapping("/students/add")
    public String addForm(Model model){
        model.addAttribute(new Student());
        return "add";
    }

    @PostMapping("/students/add")
    public String addStu(@ModelAttribute Student stu, BindingResult result){
        if(result.hasErrors()) {
            return "add";
        }
        stuSer.addStu(stu);
        return "redirect:/students";
    }


    @GetMapping("/students/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        Optional<Student> student = stuSer.findById(id);
        if(student .isPresent()){
            model.addAttribute("student", student.get());
            return "update";
        }else{
            return "redirect:/students";
        }
    }

    @PostMapping("/students/update/{id}")
    public String updateStu(@PathVariable Long id, @ModelAttribute Student student, BindingResult result){
        if(result.hasErrors()){
            return "update";
        }
        stuSer.updateStu(id, student);
        return "redirect:/students";
    }


    @GetMapping("/students/delete/{id}")
    public String delStu(@PathVariable("id") long id){
        stuSer.deleteStu(id);
        return "redirect:/students";
    }

}
