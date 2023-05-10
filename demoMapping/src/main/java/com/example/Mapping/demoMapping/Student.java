package com.example.Mapping.demoMapping;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

//    @ManyToMany()
//    private List<Teacher> teacher;

    @OneToOne(mappedBy = "student" ,cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private Teacher teacher;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public List<Teacher> getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(List<Teacher> teacher) {
//        this.teacher = teacher;
//    }



    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
