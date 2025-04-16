package io.reflectoring.studentmanagementNoSql.Controller;

import io.reflectoring.studentmanagementNoSql.entity.Student;
import io.reflectoring.studentmanagementNoSql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
     @Autowired
     private StudentService service;
     public StudentController(StudentService service){
         this.service =service;
     }
     @PostMapping
    public Student createStudent(@RequestBody Student student){
         return service.saveStudent(student);
     }
     @GetMapping
    public List<Student> getAllStudent(){
         return service.getAllStudent();
     }
     @GetMapping("/department/{dept}")
    public List<Student>getByDept(@PathVariable String dept){
         return service.getByDepartment(dept);
     }
     @GetMapping("/search")
    public List<Student>getBySearch(@RequestParam String name){
         return service.searchByName(name);
     }
}
