package practice;

public class InvalidAmountException extends Exception{
    InvalidAmountException(){
       System.out.println("Default");
    }
    InvalidAmountException(String s){
        System.out.println("Invalid Amount "+s);
    }

}
