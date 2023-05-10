package com.springBootPractice.SpringBootPracticer.service;

import com.springBootPractice.SpringBootPracticer.model.Student;
import com.springBootPractice.SpringBootPracticer.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);
    List<Teacher> getTeacher();
    Teacher getTeacherById(int id);
    Teacher updateTeacher(Teacher teacher,int id);
    void deleteTeacher(int id);

    Student saveStudent(Student student,int id);
    List<Student> getStudentsByTeacherId(int id);





}
