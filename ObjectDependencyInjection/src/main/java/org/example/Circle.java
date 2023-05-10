package org.example;

public class Circle {
    private String radius;
    private Point pointA;


    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }



    public void display(){
        System.out.println(radius);
        System.out.println(pointA.getX()+""+pointA.getY());

    }
}
