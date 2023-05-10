package org.example;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//TablePerClass
//@DiscriminatorColumn(name = "employee_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
