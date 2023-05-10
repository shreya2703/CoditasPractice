package wrapperClass;

public class UnboxingAutoboxing {
    public static void main(String[] args){
        int number1 = 50;
        System.out.println(number1);

        Integer number2 = number1;
        System.out.println(number2);
        System.out.println(number2.hashCode());
        int number3 = (int)number2;
        System.out.println(number3);
        //System.out.println(number3.hashCode());  yeh object nai hai esiliye nai only primitive pr aeyga
        System.out.println(number3+10);


    }
}
