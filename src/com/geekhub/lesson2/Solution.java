package com.geekhub.lesson2;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Form formName;
        System.out.print("Enter shape name: ");
        while (true) {
            try {
                String readShape = reader.readLine();
                formName = Form.valueOf(readShape);

                if ((formName == Form.Circle)
                        || (formName == Form.circle)
                        || (formName == Form.CIRCLE)) {
                    System.out.print("Enter circle radius: ");
                    int radius = Integer.parseInt(reader.readLine());
                    System.out.println(new Circle(radius));
                    break;
                } else if ((formName == Form.Rectangle)
                        || (formName == Form.rectangle)
                        || (formName == Form.RECTANGLE)) {
                    System.out.print("Enter rectangle width: ");
                    int width = Integer.parseInt(reader.readLine());
                    System.out.print("Enter rectangle height: ");
                    int height = Integer.parseInt(reader.readLine());
                    System.out.println(new Rectangle(width, height));
                    break;
                } else if ((formName == Form.Square)
                        || (formName == Form.square)
                        || (formName == Form.SQUARE)) {
                    System.out.print("Enter square side: ");
                    int side = Integer.parseInt(reader.readLine());
                    System.out.println(new Square(side));
                    break;
                } else if ((formName == Form.Triangle)
                        || (formName == Form.triangle)
                        || (formName == Form.TRIANGLE)) {
                    System.out.print("Enter square sideA: ");
                    int sideA = Integer.parseInt(reader.readLine());
                    System.out.print("Enter square sideB: ");
                    int sideB = Integer.parseInt(reader.readLine());
                    System.out.print("Enter square sideC: ");
                    int sideC = Integer.parseInt(reader.readLine());
                    if ((sideA + sideB > sideC)
                            && (sideC + sideB > sideA)
                            && (sideA + sideC > sideB)) {
                        System.out.println(new Triangle(sideA, sideB, sideC));
                    } else {
                        System.out.println("Error: Triangle can not exist");
                    }
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("Error: Not found. Please, enter correct shape name:");
        }
    }
}
