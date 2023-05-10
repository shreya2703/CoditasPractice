package com.springBootExample.SpringWithMYSQL.repository;

import com.springBootExample.SpringWithMYSQL.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public List<Employee> findByFirstNameStartingWith(String FirstName);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern%")
    public List<Employee> findByFirstName(@Param("pattern") String pattern);


}
