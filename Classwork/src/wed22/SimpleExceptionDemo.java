package wed22;
//exception is disrupts in smooth flow of execution
//ArithmeticException: / by zero :- name/description
//try block can come either with catch or with finally
//nested try
//if inner try block doesnt have specific catch then vo outer catch block se exception check karega like outer wala catch
//outer try ka code nested try ke baadh likho
//specification null pointer pehle phirr uske baadh exception e wala parent add at last
//multiple catches can have one try
class SimpleDemo{
    public void show(){
        System.out.println("This is  first program");
        int number1=12,number2=0,result=0;
        System.out.println("Division result is");
        try {
            try {
                result = number1 / number2;
            }
            finally{
                System.out.println("finally block");
            }
        }  catch(ArithmeticException e){  //catch(Exception e) eesa bhi likh sakte hai yeh parent hai it will handle all kind of exception
            System.out.println("Arithmetic exception occured");
            //e.printStackTrace();
            //System.out.println(e);
            //e.getMessage(); you need to write a constructor for it

        }finally {
            System.out.println("This is finally");
            //eske andhar error resolve karne ka content likhenge

        }

        System.out.println(result);
    }
}

public class SimpleExceptionDemo {
    public static void main(String[] args){
        SimpleDemo sd = new SimpleDemo();
        sd.show();

    }
}
