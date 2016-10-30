package com.geekhub.lesson2;

public class Triangle extends AbstractShape {

    private int sideA, sideB, sideC;

    public Triangle(int sideA, int sideB, int sideC)
    {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double calculateArea() {
        int p = (sideA+sideB+sideC)/2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double calculatePerimeter() {
        return (sideA +sideB+sideC);
    }

    public String toString() {
        return ("Triangle area = " + calculateArea() + ", perimeter = " + calculatePerimeter());
    }
}
