package com.geekhub.Homework5.Translator;

import com.geekhub.Homework5.Translator.source.SourceLoader;
import com.geekhub.Homework5.Translator.source.URLSourceProvider;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException {
        //initialization
        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator(new URLSourceProvider());

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!"exit".equals(command)) {
            try {
                String source = sourceLoader.loadSource(command);
                String translation = translator.translate(source);

                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);

            } catch (TranslateException e) {
                System.out.println("ERROR: " + e + ". Try again.");
            }
            command = scanner.next();
        }
    }
}
