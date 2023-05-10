class Calculator{
    int number1 = 60;
    int number2 = 20;
    int result;

    public void add(){
        result = number1 + number2;
        System.out.println("Addition is " + result);
    }

    public void subtraction(){
        result = number1 - number2;
        System.out.println("Subtraction is " + result);
    }

    public void multiplication(){
        result = number1 * number2;
        System.out.println("Multiplication is " + result);
    }

    public void division(){
        result = number1 / number2;
        System.out.println("Division is " + result);
    }
}

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.add();
        calculator.subtraction();
        calculator.multiplication();
        calculator.division();
    }


}