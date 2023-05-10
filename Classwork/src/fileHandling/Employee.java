package fileHandling;
//serialization :-
//implement serializable interface
//create new class for serialization process
//create new class for deserialization process

import java.io.Serializable;

public class Employee implements Serializable {
    int id;
    String name,city;
    transient float salary;

    //constructor parameterized

    public Employee(int id, String name, String city, float salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    //to string :- string representation of an object


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}
