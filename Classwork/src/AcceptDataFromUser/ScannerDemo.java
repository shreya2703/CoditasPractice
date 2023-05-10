package AcceptDataFromUser;

import java.util.Scanner;
//4 ways of accepting data from user
//console
//scanner util //when string at first position will work fine but in other scenario it has problem it goes to next line
//Console not working with ide
//command line interface

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int id = sc.nextInt();
        System.out.println("Entyer name");
        String name = sc.nextLine();
        System.out.println("Enter your salary");
        float salary = sc.nextFloat();

    }
}
