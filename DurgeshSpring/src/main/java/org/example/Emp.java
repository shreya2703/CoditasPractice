package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Component
public class Emp {
    @Value("Shreya")
    private String name;
//    @Value("#{phones}")
    private List<String> phone;
    private Set<String> address;
    private Map<String , String> course;

//    private Person person;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Person getPerson() {
//        return person;
//    }
//    @Autowired
//    @Qualifier("const")
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public Emp(String name, Person person) {
//        this.name = name;
//        this.person = person;
//    }
//
//    @Override
//    public String toString() {
//        return "Emp{" +
//                "name='" + name + '\'' +
//                ", person=" + person +
//                '}';
//    }

        public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public Map<String, String> getCourse() {
        return course;
    }

    public void setCourse(Map<String, String> course) {
        this.course = course;
    }
    public Emp(){

    }

    public Emp(String name, List<String> phone, Set<String> address, Map<String, String> course) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                ", course=" + course +
                '}';
    }
}
