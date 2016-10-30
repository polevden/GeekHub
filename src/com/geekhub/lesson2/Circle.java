package com.geekhub.lesson2;

public class Circle extends AbstractShape {

    final double pi = 3.1415d;
    private int radius;
    public Circle(int radius)
    {
        this.radius = radius;
    }

    public double calculateArea() {
        return(pi*radius*radius);
    }

    public double calculatePerimeter() {
        return (2*pi*radius);
    }

    public String toString() {
        return ("Circle area = " + calculateArea() + ", perimeter = " + calculatePerimeter());
    }
}
