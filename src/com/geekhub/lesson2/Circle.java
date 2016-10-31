package com.geekhub.lesson2;

public class Circle extends AbstractShape {

    private int radius;
    public Circle(int radius)
    {
        this.radius = radius;
    }

    public double calculateArea() {
        return(Math.PI*radius*radius);
    }

    public double calculatePerimeter() {
        return (2*Math.PI*radius);
    }

    public String toString() {
        return ("Circle area = " + calculateArea() + ", perimeter = " + calculatePerimeter());
    }
}
