package com.geekhub.lesson02;

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

    public double calculateTrianglePerimeter() {
        return Math.sqrt(width*width+height*height) + width + height;
    }


    public String toString() {
        return ("Rectangle area = " + calculateArea() + ", perimeter = " + calculatePerimeter()) + "\n" +
                "or two triangles with the area = " + calculateArea()/2 + " and perimeter = " + calculateTrianglePerimeter();
    }
}
