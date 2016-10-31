package com.geekhub.lesson2;

import java.io.*;

public class Solution {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int NumberDetectorInput() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Error: Incorrect input. Please, enter again: ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Form formName;
        System.out.print("Enter shape name: ");
        while (true) {
            try {
                String readShape = reader.readLine().toUpperCase();
                formName = Form.valueOf(readShape);

                if (formName == Form.CIRCLE) {
                    System.out.print("Enter circle radius: ");
                    int radius = NumberDetectorInput();
                    System.out.println(new Circle(radius));
                    break;
                } else if (formName == Form.RECTANGLE) {
                    System.out.print("Enter rectangle width: ");
                    int width = NumberDetectorInput();
                    System.out.print("Enter rectangle height: ");
                    int height = NumberDetectorInput();
                    System.out.println(new Rectangle(width, height));
                    break;
                } else if (formName == Form.SQUARE) {
                    System.out.print("Enter square side: ");
                    int side = NumberDetectorInput();
                    System.out.println(new Square(side));
                    break;
                } else if (formName == Form.TRIANGLE) {
                    while (true) {
                        System.out.print("Enter square sideA: ");
                        int sideA = NumberDetectorInput();
                        System.out.print("Enter square sideB: ");
                        int sideB = NumberDetectorInput();
                        System.out.print("Enter square sideC: ");
                        int sideC = NumberDetectorInput();
                        if ((sideA + sideB > sideC)
                                && (sideC + sideB > sideA)
                                && (sideA + sideC > sideB)) {
                            System.out.println(new Triangle(sideA, sideB, sideC));
                            break;
                        } else {
                            System.out.println("Error: Triangle can not exist. Try again!");
                        }
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
            }
            System.out.print("Error: Not found. Please, enter correct shape name: ");
        }
    }
}
