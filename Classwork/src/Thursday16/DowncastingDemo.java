package Thursday16;


class Parent{
    int drivingLicenceNumber;
    public void show(){
        System.out.println("Parent"+drivingLicenceNumber);
    }
}

class Child extends Parent{
    public void show(){
        System.out.println("Child"+drivingLicenceNumber);
    }

}
public class DowncastingDemo {
    public static void main(String[] args){
        System.out.println("Specific object");
        Child child = new Child();
        child.show();

        System.out.println("Polymorphic variable");
        Parent parent ;
        parent= new Child();
        parent.show(); //parent ko refer


        System.out.println("Downcasting");
       //Child child1 =(Child) new Parent();
        Child child1 = (Child) parent;
        child1.show(); //child ko refer
        System.out.println(parent instanceof Parent);
        System.out.println(child instanceof Child);
        System.out.println(parent instanceof Child);

        System.out.println(child instanceof Parent);
        System.out.println(child instanceof Child);

        System.out.println(child1 instanceof Parent);
        System.out.println(child1 instanceof Child);

        Child child3 = null;
        System.out.println(child3 instanceof Parent);
        System.out.println(child3 instanceof Child);



    }
}
