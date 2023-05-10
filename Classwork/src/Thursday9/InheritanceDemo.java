package Thursday9;

class Parent{
    int drivingLicenceId=121;
    public void displayData(){
        System.out.println("Parent driving licence id "+ drivingLicenceId);
    }
}


class Child extends Parent{
    int aadharCardId=131;
    public void displayData(){

        //super.drivingLicenceId=128; //this will change the value in parent class also
        super.displayData(); //super class help to achieve parent class property in child
        System.out.println("Child Aadhar id "+ aadharCardId);
        System.out.println("Child driving licence id "+ drivingLicenceId);
        drivingLicenceId=132;   //without super also value can get update in this

        System.out.println("Child driving licence id "+ drivingLicenceId);

    }
}


public class InheritanceDemo {

    public static void main(String[] args){
        Child child = new Child();
        child.displayData();

       //Parent parent = new Parent();    //this is not reuseability of code
        //parent.displayData();

    }
}
