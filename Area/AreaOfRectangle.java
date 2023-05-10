package Area;

class Rectangle{
    private int length;
    private int breadth;

    private int area;
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }


    public int getArea() {
        area=length*breadth;
        return area;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", breadth=" + breadth +
                ", area=" + area +
                '}';
    }
}




public class AreaOfRectangle {

    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setBreadth(5);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle);
    }
}
