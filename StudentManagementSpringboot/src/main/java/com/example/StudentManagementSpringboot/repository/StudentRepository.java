package com.example.StudentManagementSpringboot.repository;

import com.example.StudentManagementSpringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
