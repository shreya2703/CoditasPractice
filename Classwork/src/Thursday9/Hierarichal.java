package Thursday9;

class Saif{
    String parentName="Saif";
    public void displayData(){
        System.out.println("Parent name "+ parentName);
    }

}

class Taimur extends Saif{

    String childName="Taimur";
    public void displayData(){
        super.displayData();
        System.out.println("child name "+ childName);
    }

}

class Sara extends Saif{
    String bchildName="Sara";
    public void displayData(){
        super.displayData();
        System.out.println("child name "+ bchildName);
    }
}


public class Hierarichal {
    public static void main(String[] args){
        System.out.println("*******Sara****************");
        Sara s = new Sara();
        s.displayData();
        System.out.println("*******Taimur****************");
        Taimur t = new Taimur();
        t.displayData();


    }



}
