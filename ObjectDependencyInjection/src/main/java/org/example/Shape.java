package org.example;

public class Shape {

    private Triangle t;
    private Circle c;

    public Triangle getT() {
        return t;
    }

    public void setT(Triangle t) {
        this.t = t;
    }

    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public void display() {
     getT().display();
     getC().display();

    }
}
