package practice_file_handling;

import java.io.*;

public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
//        try {
            FileOutputStream fs1 = new FileOutputStream("File1.txt");
            FileOutputStream fs2 = new FileOutputStream("File2.txt");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            os.write(65);
            os.write(70);
            os.writeTo(fs1);
            os.writeTo(fs2);

//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        //ByteArrayInputStream :- It is used to read byte array as an input

        byte b[] ={45,78,90,67};
        ByteArrayInputStream bs = new ByteArrayInputStream(b);
        int i=0;
        while((i=bs.read())!=-1){
            System.out.println(i);
        }


    }
}
