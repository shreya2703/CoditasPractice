package practice_file_handling;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) {

        try {
            BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("File2.txt"));
            bo.write(67);
            bo.write(69);
            bo.flush();
            bo.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            BufferedInputStream bs = new BufferedInputStream(new FileInputStream("File2.txt"));
            int i=0;
            while((i=bs.read())!= -1){
                System.out.println((char)i);
            }
            bs.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
