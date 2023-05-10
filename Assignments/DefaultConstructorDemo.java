//class Test{
//static int a;
//Test(){
//a=10;
//System.out.println(a);
//System.out.println("Default Constructor");
//}


//public void show(){
//System.out.println(a);

//}

//}


public class DefaultConstructorDemo{

//public static void main(String[] args){
// Test obj = new Test();
// obj.show();

//}


String firstName;
  String lastName;
  int age;
  
  public static void main(String args[]) {
      DefaultConstructorDemo myStudent = new DefaultConstructorDemo();
      
      myStudent.firstName = "Ihechikara";
      myStudent.lastName = "Abba";
      myStudent.age = 100;
      
      System.out.println(myStudent.age);
      //100
      
      System.out.println(myStudent.firstName);
      //Ihechikara
  }
}

