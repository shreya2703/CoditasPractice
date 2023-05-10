package customException;

public class AgeNotValidException extends RuntimeException{
    AgeNotValidException(){
        System.out.println("Default");
    }
    AgeNotValidException(String s){
        System.out.println("minor "+s);
    }
    AgeNotValidException(Throwable cause){
        System.out.println("Throwable "+cause);
    }
    AgeNotValidException(Throwable cause, String s){
        System.out.println("Throwable string");
    }


}
