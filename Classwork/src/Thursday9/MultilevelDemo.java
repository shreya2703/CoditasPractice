package Thursday9;

class Randheer{
    String grandparentName="Randheer";
    public void displayData(){
        System.out.println("GrandParent name "+ grandparentName);
    }
}

class Kareena extends Randheer{
    String parentName="Kareena";
    public void displayData(){
        super.grandparentName="Babita";
        super.displayData();
        System.out.println("Parent name "+ parentName);
    }
}

//class Taimur extends Kareena{
  //  String childName="Kareena";
  //  public void displayData(){
  //      super.displayData();
  //      System.out.println("child name "+ childName);
  //  }
//}


public class MultilevelDemo {
    public static void main(String[] args) {
       // Taimur taimur = new Taimur();
      //  taimur.displayData();
    }
}
