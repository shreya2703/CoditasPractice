package practice_file_handling;

import java.io.*;

public class BufferCharDemo {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("New.txt"));
            bw.write("Welcome to coditas");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("New.txt"));
            int i=0;
            while((i=br.read())!=-1){
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
