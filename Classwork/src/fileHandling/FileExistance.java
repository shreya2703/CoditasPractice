package fileHandling;

import java.io.File;
import java.io.IOException;

public class FileExistance {
    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");
        if(file.exists()){
            System.out.println("Exists");
        }
        else {

            System.out.println(" Not Exists");
            file.createNewFile();
            System.out.println("File created");

        }
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.getName());
        System.out.println(file.canExecute());
    }
}
