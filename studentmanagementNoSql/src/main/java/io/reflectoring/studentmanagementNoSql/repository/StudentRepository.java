package io.reflectoring.studentmanagementNoSql.repository;

import io.reflectoring.studentmanagementNoSql.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {
List<Student> findByDepartment(String department);
List<Student> findByNameContaining(String name);
}
