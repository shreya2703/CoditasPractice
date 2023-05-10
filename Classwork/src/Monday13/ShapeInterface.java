package Monday13;


//jo bydefault hai usse mention karne ki jarurat nai like edhar abstract keyword use karne ki jarurat nai coz interface ke method by default abstract hai

//you can use default or static for method defination
public interface ShapeInterface {
    public void area();
    default void display(){

    }
    static void show(){

    }


}



//class Rectangle implements ShapeInterface{

//}
class InterfaceDemo{
    public static void main(String[] args){

    }
}