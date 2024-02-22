package com.student.student;
import com.student.student.entity.Student;
import com.student.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository){
        return args -> {
            repository.saveAll(List.of(
                new Student("Bobby", 150, 30, "red", 2.5,"cs"),
                new Student("Steve", 200, 30, "blue", 3.6,"arts"),
                new Student("Dan", 120, 50, "green", 4.0,"crim"),
                    new Student("Leo", 10, 300, "purple", 3.0,"com"),
                    new Student("Tu", 2000, 20, "yellow", 3.2,"eng"),
                    new Student("Pu", 100, 50, "brown", 4.6,"psyc")
            ));
        };
    }
}
