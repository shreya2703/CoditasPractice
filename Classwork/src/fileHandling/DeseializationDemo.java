package fileHandling;

 import java.io.*;

public class DeseializationDemo extends Thread {


    public static void main(String[] args) {



        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("employeeData.txt"));
            Employee e = (Employee) o.readObject();
            System.out.println("DESerialization done");
            System.out.println(e.city+" "+e.name+" "+e.salary+" "+e.id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
   // DESerialization done to read the file
   // Dewas Shreya 5000.0 122