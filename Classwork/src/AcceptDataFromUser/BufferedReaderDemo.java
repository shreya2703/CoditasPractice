package AcceptDataFromUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("id");
            int id =Integer.parseInt( b.readLine());
            System.out.println("marks");
            float marks = Float.parseFloat(b.readLine());//float is primitive string is object string to float object then left m primitive so parse float
            System.out.println("name");
            String name = b.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
