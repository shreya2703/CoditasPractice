package practice_file_handling;

import java.io.*;
import java.util.Arrays;
//common data to multiple files

public class CharArrayDemo {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter fw1 = new FileWriter("New.txt");
            FileWriter fw2 = new FileWriter("File1.txt");
            FileWriter fw3 = new FileWriter("File2.txt");

            CharArrayWriter cha = new CharArrayWriter();
            cha.write("Hii shreya here");
            cha.writeTo(fw1);
            cha.writeTo(fw2);
            cha.writeTo(fw3);
            cha.close();
            fw1.close();
            fw2.close();
            fw3.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] ch ={'a','b','c'};
        CharArrayReader chr = new CharArrayReader(ch);
        int i=0;
        while((i=chr.read())!=-1){
            System.out.print((char)i);

        }







    }
}
