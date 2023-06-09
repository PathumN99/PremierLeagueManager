package com.server.plmserver.Student;

import com.server.plmserver.Student.repository.StudentRepository;
import com.server.plmserver.Student.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> findAllStudent() {
        return studentRepository.findAll();
    }


    public Optional<StudentEntity> findStudent(Long id) {
        return studentRepository.findById(id);
    }

    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student successfully deleted!";
    }


}
