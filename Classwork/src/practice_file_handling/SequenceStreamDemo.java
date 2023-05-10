package practice_file_handling;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceStreamDemo {


    public static void main(String[] args) {
        try {
            FileInputStream f1 = new FileInputStream("abc.txt");
            FileInputStream f2 = new FileInputStream("File1.txt");
            FileInputStream f3 = new FileInputStream("File2.txt");

            FileOutputStream f0 = new FileOutputStream("Output.txt");
            Vector v = new Vector();
            v.add(f1);
            v.add(f2);
            v.add(f3);

            Enumeration e = v.elements();

            SequenceInputStream si = new SequenceInputStream(e);
            int i=0;
            while((i=si.read())!=-1){
                f0.write(i);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
