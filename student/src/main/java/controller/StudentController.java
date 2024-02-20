package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.student.Entity.Student;
import com.student.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService stuService;

    @Autowired
    public StudentController(StudentService stuService) {
        this.stuService = stuService;
    }

    @GetMapping
    public List<Student> getAllStu() {
        return stuService.getAllStu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStuByID(@PathVariable Long id) {
        return stuService.getStuById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student addStu(@RequestBody Student student) {
        return stuService.addStu(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStu(@PathVariable Long id, @RequestBody Student stuInfo) {
        return stuService.getStuById(id)
                .map(student -> {
                    student.setName(stuInfo.getName());
                    student.setWeight(stuInfo.getWeight());
                    student.setHeight(stuInfo.getHeight());
                    student.setHairColor(stuInfo.getHairColor());
                    student.setGpa(stuInfo.getGpa());
                    Student updatedStu = stuService.updateStu(student);
                    return ResponseEntity.ok(updatedStu);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStu(@PathVariable Long id) {
        return stuService.getStuById(id)
                .map(student -> {
                    stuService.deleteStu(student.getId());
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
