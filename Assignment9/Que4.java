package Assignment9;


abstract  class Shape{
    abstract public void area();
}
class Circle extends Shape{
    public void area(){
        System.out.println("This is the area of circle");
    }
}
class Square extends Shape{
    public void area(){
        System.out.println("This is the area of square");
    }
}

class Cylinder extends Circle{
    public void area(){
        super.area();
    }

}

class Rectangle extends Square{
    public void area(){
        super.area();
        System.out.println("This is area of rectangle");
    }
}
public class Que4 {
    public static void main(String[] args){

       //Rectangle r = new Rectangle();
      // r.area();
      // Cylinder c = new Cylinder();
     //  c.area();

//       Shape[] shape = new Shape[1];
//       shape[0] = new Circle();
//       for(int i=0;i<1;i++){
//           shape[i].area();
//       }

        Shape[] shape = new Shape[1];
        shape[0] = new  Rectangle();
        for(int i=0;i<1;i++){
           shape[i].area();
      }

    }
}
