package Monday13;

//in any simple class if u declare a method that method needs to be declared as an abstract method
//in any simple class if you have declared an abstract(), that class need to be declared as an abstract class
//declare any class as abstract class and it may or may not have any abstract method or concreete method
//if any subclass wants to extend this abstract class then
        //they have to implement all the abstract method and provide the implementation
        //if subclass failed to do so then that subclass need to declare itself as abstract class
//you can instantiate an abstract class or you can not create an object of abstract class abstract public Circle extends shape
//anonymous class or object in inner class m dekhenge




abstract class Shape{
    public abstract void area();

    //concrete method
    public void display(){
        System.out.println("this is shape class display");
    }
}


class
Circle extends Shape{

    public void area(){
        System.out.println("Circle class area");
    }

}
public class ShapeDemo {

    public static void main(String[] args){
        Circle circle = new Circle();
        circle.area();
        circle.display();

    }


}
