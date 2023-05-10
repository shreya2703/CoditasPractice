package com.springBootPractice.SpringBootPracticer.repository;

import com.springBootPractice.SpringBootPracticer.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
