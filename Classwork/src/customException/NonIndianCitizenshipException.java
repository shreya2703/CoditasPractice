package customException;
//nationality important hai thats why esse checked during compile time pr
//compile time so extends exception
public class NonIndianCitizenshipException extends Exception{
    NonIndianCitizenshipException(){
            System.out.println("Default");
    }
    NonIndianCitizenshipException(String s){
        System.out.println("Not indian "+s);
    }
    NonIndianCitizenshipException(Throwable cause){
        System.out.println("Throwable "+cause);
    }
    NonIndianCitizenshipException(Throwable cause, String s){
        System.out.println("Throwable string");
    }
}
