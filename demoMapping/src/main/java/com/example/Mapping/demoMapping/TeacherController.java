package com.example.Mapping.demoMapping;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

//    @PostMapping("/teachers")
//    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
//        Teacher savedTeacher = teacherRepository.save(teacher);
//        return ResponseEntity.created(URI.create("/api/teachers/" + savedTeacher.getId()))
//                .body(savedTeacher);
//    }
//
//    @PostMapping("/teachers/{teacherId}/students")
//    public ResponseEntity<Student> createStudent(@PathVariable Long teacherId, @RequestBody Student student) {
//        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
//        if (optionalTeacher.isPresent()) {
//            Teacher teacher = optionalTeacher.get();
//            student.getTeacher().add(teacher);
//            Student savedStudent = studentRepository.save(student);
//            return ResponseEntity.created(URI.create("/api/teachers/" + teacherId + "/students/" + savedStudent.getId()))
//                    .body(savedStudent);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
        @PostMapping("/student")
         public Student createStudent(@RequestBody Student student) {
//          student.getTeacher().setStudent(student);
          Student student1 = studentRepository.save(student);
            System.out.println(student1);
          return student1;
}
    @PostMapping("/teacher/{id}")
    public Teacher createTeacher(@RequestBody Teacher teacher,@PathVariable("id") long id) {
          Optional<Student> student2 = studentRepository.findById(id);
        teacher.setStudent(student2.get());
        Teacher teacher1 = teacherRepository.save(teacher);
        System.out.println(teacher1);
        return teacher1;

    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id){
            studentRepository.deleteById(id);

    }
//    public List<Student> getStudent(){
//            return studentRepository.findAll();
//    }



//@PostMapping("/students")
//public ResponseEntity<?> createStudent(@RequestBody Student student, HttpServletResponse response) throws IOException {
//    try {
////        Teacher teacher = teacherRepository.findById(student.getTeacher().getId()).orElse(null);
////        if (teacher == null) {
////            response.sendError(400, "Teacher not found");
////            return ResponseEntity.badRequest().build();
////        }
//
//        student.setTeacher(teacher);
//        studentRepository.save(student);
//        return ResponseEntity.ok(student);
//    } catch (Exception e) {
//        response.sendError(500, "An error occurred while creating the student.");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    } finally {
//        response.getWriter().flush();
//    }
//}

}
