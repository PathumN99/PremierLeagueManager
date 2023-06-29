package com.server.plmserver.Student;

import com.server.plmserver.Student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<StudentEntity> findStudent(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {
        return studentService.saveStudent(studentEntity);
    }

    @PutMapping("/update/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentEntity) {
        studentEntity.setId(id);
        return studentService.updateStudent(studentEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }


}
