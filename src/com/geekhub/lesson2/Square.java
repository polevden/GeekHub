package com.geekhub.lesson2;

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

    public String toString() {
        return ("Square area = " + calculateArea() + ", perimeter = " + calculatePerimeter());
    }
}
