package org.example;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Student_Id")
    private int id;
    private String name;
    private String address;
    private String division;

    @OneToOne
    private Teacher tecaher;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Teacher getTecaher() {
        return tecaher;
    }

    public void setTecaher(Teacher tecaher) {
        this.tecaher = tecaher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", division='" + division + '\'' +
                ", tecaher=" + tecaher +
                '}';
    }
}
