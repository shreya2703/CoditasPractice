package L2Practice;

class Parent{
    int a=10;
     void display()throws Exception{
        System.out.println("Parent method");
    }
}
class Child extends Parent{
    int a =20;

     void display() throws Exception {
         super.display();
        System.out.println("Child method");
    }

}
public class OverridingDemo {
    void add(double a,double b){
        System.out.println("double");
    }
    void add(float a,float b){
        System.out.println("float");
    }
    public static void main(String[] args) throws Exception {
        OverridingDemo overridingDemo = new OverridingDemo();
        overridingDemo.add(10,10);
        Child p = new Child();
        p.display();
        System.out.println(p.a);


    }
}
