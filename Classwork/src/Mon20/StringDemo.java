package Mon20;

class StringWays{
    public void display(){
        //way 1 literal way
        String name = "Aarti";
        String name2 ="Aarti";
        String name4 ="aarti";
        String name3 ="Kriti";
        System.out.println("Name is:: "+name);
      //  name.concat("Dhumal");     //it will not because once created cannot change it if you want you can re intialize it to other
      //  System.out.println("full name is:: "+name);
      //  name = name.concat("Dhumal");  //this is possible



        //way 2 object way
        String name1 = new String("How are you ?");
        System.out.println("Message is ::"+name1);
        String fullName = new String();
        name1.concat("I am Fine");
        System.out.println(name1);
        fullName = name1.concat("I am ok");
        System.out.println(fullName);


        //Methods

        //1)Compare 2 Strings

         //For Literal
        //way1:equals() //its case sensitive
        System.out.println(name.equals(name2));
        System.out.println(name.equals(name4));


        //way2: ==  //strictly check for the value case sensitive
        System.out.println(name == name4);

        //way3 : compare to()
        System.out.println(name.compareTo(name4)); //both string exact same then 0 if first string greater than second than positive value otherwise negative


        System.out.println("For object");

        String name7 = new String("aarti");
        String name8 = new String("Aarti");
        String name9 = new String("Aarti");
        //For object
        //way1:equals() //its case sensitive
        System.out.println(name8.equals(name9));
        System.out.println(name8.equals(name7));


        //way2: ==  //strictly check for the value case sensitive
        System.out.println(name8 == name7);

        //way3 : compare to()
        System.out.println(name8.compareTo(name7)); //both string exact same then 0 if first string greater than second than positive value otherwise negative


        System.out.println("   different  ");
        System.out.println(name.equals(name8)); //
        System.out.println(name == name8); //yeh address check karr raha hai
        System.out.println(name9 == name8); // in heap they are scatterd so they are not same
        System.out.println(name.compareTo(name8));//spelling + lexi
        //if === data type check karega its their in javascript


        //How to deal with compare ?

        //Assignment all the string method important : intern, codepointat


    }
}




public class StringDemo {
    public static void main(String[] args){
        StringWays stringWays = new StringWays();
        stringWays.display();



    }

}
