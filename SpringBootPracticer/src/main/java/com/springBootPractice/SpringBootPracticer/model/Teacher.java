package com.springBootPractice.SpringBootPracticer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String addres;
    @OneToMany(mappedBy = "teacher",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

//    public List<Student> getStudent() {
//        return student;
//    }

    public Teacher() {

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }


}
