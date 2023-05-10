package practice_file_handling;


import java.io.*;

public class FileHandlingDemo {
    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("File2.txt");
        os.write(66);
        os.write(68);
        String str =" Hello everyone";
        byte b[] = str.getBytes();
        os.write(b);
        //os.close();


        InputStream is = new FileInputStream("File2.txt");
        int i=0;
        while((i=is.read())!=-1){
            System.out.println((char)i);
        }
       // is.close();


    }
}
