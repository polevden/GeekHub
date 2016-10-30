package com.geekhub.lesson2;

public class Rectangle extends AbstractShape {

    private int width, height;

    public Rectangle(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return (width*height);
    }

    public double calculatePerimeter() {
        return (width+height)*2;
    }

    public String toString() {
        return ("Rectangle area = " + calculateArea() + ", perimeter = " + calculatePerimeter());
    }
}
