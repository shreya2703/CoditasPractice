package practice_file_handling;

import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args)  {
        try {
            DataOutputStream ds = new DataOutputStream(new FileOutputStream("File1.txt"));
            ds.writeChars("M");
            ds.writeInt(78);
            ds.flush();
            ds.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream("File1.txt");
            DataInputStream dis = new DataInputStream(fis);
            byte b[] = new byte[fis.available()];
            dis.read(b);
            for(byte b1: b){
                char data = (char)b1;
                System.out.println(data);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
