package com.geekhub.lesson02;

public class Square extends AbstractShape {

    private int side;

    public Square(int side)
    {
        this.side= side;
    }

    public double calculateArea() {
        return (side*side);
    }

    public double calculatePerimeter() {
        return (side*4);
    }

    public double calculateTrianglePerimeter() {
        return Math.sqrt(side*side+side*side) + side*2;
    }

    public String toString() {
        return ("Square area = " + calculateArea() + ", perimeter = " + calculatePerimeter() + "\n" +
                "or two triangles with the area = " + calculateArea()/2 + " and perimeter = " + calculateTrianglePerimeter());
    }
}
