package fileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreams {
    public static void main(String[] args) throws IOException {

        try {
            FileInputStream fp = new FileInputStream("abc.txt");
            System.out.println(fp.read());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
