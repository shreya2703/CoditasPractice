package org.example;


import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Teacher_Id")
    private int id;
    private String name;
    private String subject;
    private int experience;

    //For unidirectional @OneToOne is not required
    //For Bidirectional mapping we can use @OneToOne here also
    //This constraint mapped by help us to not create a foreign key(student) column in teacher
    @OneToOne(mappedBy = "tecaher")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", experience=" + experience +
                //", student=" + student +
                '}';
    }
}
