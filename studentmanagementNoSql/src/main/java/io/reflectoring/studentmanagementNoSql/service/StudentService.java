package io.reflectoring.studentmanagementNoSql.service;

import io.reflectoring.studentmanagementNoSql.entity.Student;
import io.reflectoring.studentmanagementNoSql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public  StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> getAllStudent(){
        return repository.findAll();
    }

    public List<Student>getByDepartment(String department){
        return repository.findByDepartment(department);
    }
    public List<Student>searchByName(String name){
        return repository.findByNameContaining(name);
    }
}
