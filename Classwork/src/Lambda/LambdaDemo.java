package Lambda;



interface FunctionalInterface{

  void abstractFunction(int x);
  default void add(){
      System.out.println("Default add method");
  }

  static void sub(){
      System.out.println("Static sub method");
  }

}
public class LambdaDemo {
    public static void main(String[] args) {
        FunctionalInterface f2 = new FunctionalInterface() {
            @Override
            public void abstractFunction(int x) {
                System.out.println(10*x);
            }
        };
        f2.abstractFunction(2);


        FunctionalInterface f1 = (int x) -> System.out.println("Details are:: "+10*x);
        f1.abstractFunction(5);
        f1.add();
        FunctionalInterface.sub();



    }





}
