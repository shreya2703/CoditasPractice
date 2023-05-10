package comparator;

import java.util.Comparator;

//name wise sort
public class Student {
    int rno;
    String name,city;
    public Student(int rno,String name,String city){
        this.rno = rno;
        this.name=name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class SortByRoll implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.rno-o2.rno ;
    }


}
class  SortByCity implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.city.compareTo(o2.city);
    }
}

