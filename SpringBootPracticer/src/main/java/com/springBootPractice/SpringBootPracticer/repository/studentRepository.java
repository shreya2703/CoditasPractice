package com.springBootPractice.SpringBootPracticer.repository;

import com.springBootPractice.SpringBootPracticer.model.Student;
import com.springBootPractice.SpringBootPracticer.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface studentRepository extends JpaRepository<Student,Integer> {
//    @Query("Select s from Student where s.teacher_id=:teacher_id")
//    List<Student> findByTeacherId(@Param("teacher_id") int teacherId);
}
