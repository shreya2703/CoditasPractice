package fileHandling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("employeeData.txt"));
            //to persist an object of employee create it first
            Employee e = new Employee(122,"Shreya","Dewas",5000);
            o.writeObject(e);
            System.out.println("Serialization done");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

//output without transient keyword

//�� sr fileHandling.Employee�l &�-� I idF salaryL cityt Ljava/lang/String;L nameq ~ xp   zE�@ t Dewast Shreya

//when you dont want some property to behave like serialize so you make that transient
//after transient salary has been removed from this

//�� sr fileHandling.Employeed�¬I�� I idL cityt Ljava/lang/String;L nameq ~ xp   zt Dewast Shreya