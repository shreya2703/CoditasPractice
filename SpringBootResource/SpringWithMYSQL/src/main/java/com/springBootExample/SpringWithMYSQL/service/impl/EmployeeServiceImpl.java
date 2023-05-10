package com.springBootExample.SpringWithMYSQL.service.impl;

import com.springBootExample.SpringWithMYSQL.exception.ResourceNotFoundException;
import com.springBootExample.SpringWithMYSQL.model.Employee;
import com.springBootExample.SpringWithMYSQL.repository.EmployeeRepository;
import com.springBootExample.SpringWithMYSQL.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee= employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }
       else {
           throw new ResourceNotFoundException("Employee","Id",id);
       }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
