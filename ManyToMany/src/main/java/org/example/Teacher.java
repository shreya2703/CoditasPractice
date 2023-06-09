package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Teacher_Id")
    private int id;
    private String name;
    private String subject;
    private int experience;

    //To change the name of the third column generated by this we will use joincolumn annotation
    //it have two things @JoinColumns this is for teacher id and
    // @InverseJoinColumns this is for student id
    @ManyToMany
    @JoinTable(
            name="TeacherStudent" ,
            joinColumns={@JoinColumn(name="t_id")},
            inverseJoinColumns = {@JoinColumn(name="s_id")}
            )
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", experience=" + experience +
                ", student=" + student +
                '}';
    }
}
