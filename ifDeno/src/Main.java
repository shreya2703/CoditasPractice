import java.util.*;
class SimpleIf{
    public void display(){
        int number1=10;
        if(number1>100)
            System.out.println(number1);
    }
}

class IfElseDemo{

}

class IfElseLadderDemo{

}

class ForLoopDemo{

}

class PrintPatter{
    public void displayData(){
        for(int i=1;i<5;i++){ //row
            for(int j=1;j<=5;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SimpleIf simpleif = new SimpleIf();
        simpleif.display();

        PrintPattern printpattern = new PrintPattern();
        printpatter.displayData();


    }
}