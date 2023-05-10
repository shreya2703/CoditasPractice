package com.springBootPractice.SpringBootPracticer.controller;

import com.springBootPractice.SpringBootPracticer.exception.ResourceNotFoundException;
import com.springBootPractice.SpringBootPracticer.model.Student;
import com.springBootPractice.SpringBootPracticer.model.Teacher;
import com.springBootPractice.SpringBootPracticer.service.TeacherService;
import jakarta.persistence.TypedQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
 private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;

    }

    //To save
    @PostMapping("/teacher")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }
    @PostMapping("/student/{id}")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student, @PathVariable("id") int teacherId){
        return new ResponseEntity<Student>(teacherService.saveStudent(student,teacherId), HttpStatus.CREATED);
    }



//    @GetMapping("/teachers/{id}/students")
//    public List<Student> getStudentsByTeacher(@PathVariable("id") int id) {
//        return (List<Student>) new ResponseEntity<List<Student>>(teacherService.getStudentsByTeacher(id),HttpStatus.OK);
////        Teacher teacher = teacherRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));
////        return studentRepository.findByTeacher(teacher);
//    }

//    @GetMapping("/teachers/{id}/students")
//    public List<Student> getStudentsByTeacherId(@PathVariable(value = "id") Long teacherId) {
//        TypedQuery<Student> query = entityManager.createQuery(
//                "SELECT s FROM Student s WHERE s.teacher.id = :teacherId", Student.class);
//        query.setParameter("teacherId", teacherId);
//        return query.getResultList();
//    }

//    @GetMapping("/query/{id}")
//    public ResponseEntity<List<Student>> getStudentsByTeacher(@PathVariable("teacherId") int teacherId) {
//        List<Student> students = teacherService.getStudentsByTeacher(teacherId);
//        return ResponseEntity.ok(students);
//    }

    @GetMapping("/students/{teacherId}")
    public List<Student> getStudentsByTeacherId(@PathVariable int teacherId) {
        return teacherService.getStudentsByTeacherId(teacherId);
    }





    //To get all
    @GetMapping()
    public List<Teacher> getTeacher(){
       return teacherService.getTeacher();
    }

    //To get By id
    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id){
        return new ResponseEntity<>(teacherService.getTeacherById(id),HttpStatus.OK);
    }

    //To update
   @PutMapping("{id}")
   public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher,@PathVariable("id") int id){
       return new ResponseEntity<>(teacherService.updateTeacher(teacher,id),HttpStatus.OK);
   }

    //To delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") int id){
        teacherService.deleteTeacher(id);
        return new ResponseEntity<String>("deleted Sucesfully",HttpStatus.OK);

    }




}
