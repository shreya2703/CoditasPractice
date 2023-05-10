class Addition{
    int number1;
    int number2,result=0;
    public void add(){
        //System.out.println("Addition");

        result=number1+number2;
        System.out.println(result);


    }
}




public class Main {
    public static void main(String[] args) {
        int number1,number2,result=0;
        System.out.println("Hello world!");
        Addition addition = new Addition();

        //addition.number1=10;
        //addition.number2=10;
        addition.add();

        addition.number1=10;
        addition.number2=10;
        addition.add();
    }
}