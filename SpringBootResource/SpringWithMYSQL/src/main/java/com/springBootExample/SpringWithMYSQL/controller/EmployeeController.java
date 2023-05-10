package com.springBootExample.SpringWithMYSQL.controller;

import com.springBootExample.SpringWithMYSQL.model.Employee;
import com.springBootExample.SpringWithMYSQL.repository.EmployeeRepository;
import com.springBootExample.SpringWithMYSQL.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

//    public EmployeeController(EmployeeService employeeService) {
//
//        this.employeeService = employeeService;
//    }


    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }
    //build get all employees
    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //build get employee by id
    @GetMapping("{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
         return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
     }

     //build Employee update Rest API
    @PutMapping("{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);

     }

     //build Delete employee Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);

    }


    @GetMapping("/query/{pattern}")
    public List<Employee> getAllEmployees(@PathVariable("pattern") String pattern) {
        return employeeRepository.findByFirstName(pattern);

    }

    @GetMapping("/starting/{pattern}")
    public List<Employee> getName(@PathVariable("pattern") String pattern){
        return employeeRepository.findByFirstNameStartingWith(pattern);
    }
}
