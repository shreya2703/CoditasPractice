package com.springBootPractice.SpringBootPracticer.service.impl;

import com.springBootPractice.SpringBootPracticer.exception.ResourceNotFoundException;
import com.springBootPractice.SpringBootPracticer.model.Student;
import com.springBootPractice.SpringBootPracticer.model.Teacher;
import com.springBootPractice.SpringBootPracticer.repository.TeacherRepository;
import com.springBootPractice.SpringBootPracticer.repository.studentRepository;
import com.springBootPractice.SpringBootPracticer.service.TeacherService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    private studentRepository studenrepository;


//    public TeacherServiceImpl(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }

    public TeacherServiceImpl(TeacherRepository teacherRepository, studentRepository studenrepository) {
        this.teacherRepository = teacherRepository;
        this.studenrepository = studenrepository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()) {
            return teacher.get() ;
        }
        else{
            throw new ResourceNotFoundException("Teacher","Id",id);
        }
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, int id) {

       Teacher t = teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher","id",id));
       t.setId(teacher.getId());
       t.setName(teacher.getName());
       t.setAddres(teacher.getAddres());
       teacherRepository.save(t);
       return t;

    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher","id",id));
      teacherRepository.deleteById(id);


    }
    @Override
    public Student saveStudent(Student student, int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", teacherId));
        student.setTeacher(teacher);
        return studenrepository.save(student);

    }


    public List<Student> getStudentsByTeacherId(int teacherId) {
        List<Student> students = studenrepository.findAll();
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getTeacher().getId() == teacherId) {
                result.add(student);
            }
        }

        return result;
    }


}
