package com.geekhub.Lesson04.Homework02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeWordAbbreviation {
    public static void main(String[] args){
        System.out.println("Enter the number of rows: ");
        Scanner in = new Scanner(System.in);
        showList(wordsListCreator(in, rowsNumber(in)));
        in.close();
    }

    private static int rowsNumber(Scanner in) {
        while (true) {
            try {
                int inputValue = Integer.parseInt(in.nextLine());
                if (inputValue < 1 || inputValue > 100) {
                    throw new IOException();
                } else {
                    in.reset();
                    return inputValue;
                }
            } catch (Exception e) {
            }
        }
    }

    private static List wordsListCreator(Scanner in, int rowsNumber) {
        List<String> wordsList = new ArrayList<>(rowsNumber);
        for (int i = 0; i < rowsNumber; i++) {
            String word;
            while (true) {
                word = in.nextLine();
                if (isValidValue(word)) {
                    break;
                }
            }
            wordsList.add(wordChanger(word));
        }
        return wordsList;
    }

    private static String wordChanger(String word) {
        if (word.length() > 10) {
            return String.valueOf(word.charAt(0))
                    + String.valueOf(word.length() - 2)
                    + String.valueOf(word.charAt(word.length() - 1));
        } else {
            return word;
        }
    }

    private static void showList(List wordsList) {
        for (Object word : wordsList) {
            System.out.println(word);
        }
    }

    private static boolean isValidValue(String readLine) {
        if (readLine.length() > 100 || readLine.length() < 1) {
            return false;
        }
        for (char ch : readLine.toCharArray()) {
            if (ch == ' ') {
                return false;
            }
            for (char charFields : "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray()) {
                if (ch == charFields) {
                    return false;
                }
            }
        }
        return true;
    }
}
