package com.springBoot.springexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Shreya","Kalluraya");
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add( new Student("Shreya","Kalluraya"));
        students.add( new Student("Yash","Paliwal"));
        students.add( new Student("Krati","Tare"));
        students.add( new Student("Aryaman","Bhawasar"));
        students.add( new Student("Harini","Bathini"));
        return students;
    }
    //path variable localhost:8080/students/shreya/kalluraya

     @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    //REST API to handle query params localhost:8080/student?firstName=Shreya&lastName=Kalluraya
    @GetMapping("/student/query")
    public Student studentQueryParams(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName){


        return new Student(firstName, lastName);

    }




}
