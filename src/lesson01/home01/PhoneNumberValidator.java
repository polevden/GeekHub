package lesson01.home01;

import java.io.*;

public class PhoneNumberValidator {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, round = 0;
        long number;
        String s = "";
        System.out.println("Please enter a phone number:");
        while (true) {
            try {
                s = reader.readLine();
                if (s.length() == 10) {
                    if (String.valueOf(s.charAt(0)).equals("0")) {
                        break;
                    }
                } else if (s.length() == 11) {
                    if (String.valueOf(s.charAt(1)).equals("0")) {
                        if (String.valueOf(s.charAt(0)).equals("8")) {
                            number = Long.parseLong(s);
                            break;
                        }
                    }
                } else if (s.length() == 12) {
                    if (String.valueOf(s.charAt(2)).equals("0")) {
                        if (String.valueOf(s.charAt(1)).equals("8")) {
                            if (String.valueOf(s.charAt(0)).equals("3")) {
                                number = Long.parseLong(s);
                                break;
                            }
                        }
                    }
                } else if (s.length() == 13) {
                    if (String.valueOf(s.charAt(3)).equals("0")) {
                        if (String.valueOf(s.charAt(2)).equals("8")) {
                            if (String.valueOf(s.charAt(1)).equals("3")) {
                                if (String.valueOf(s.charAt(0)).equals("+")) {
                                    s = s.substring(1);
                                    number = Long.parseLong(s);
                                    break;
                                }
                            }
                        }
                    }
                } else if (s.length() == 14) {
                    if (String.valueOf(s.charAt(4)).equals("0")) {
                        if (String.valueOf(s.charAt(3)).equals("8")) {
                            if (String.valueOf(s.charAt(2)).equals("3")) {
                                if (String.valueOf(s.charAt(1)).equals("0")) {
                                    if (String.valueOf(s.charAt(0)).equals("0")) {
                                        number = Long.parseLong(s);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("Phone number is incorrect. Please enter a phone number:");
            } catch (Exception e) {
                System.out.println("Phone number is incorrect. Please enter a phone number:");
            }
        }
        System.out.println("Phone number is correct.");
        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            s = String.valueOf(sum);
            sum = 0;
            round++;
            System.out.println(round + "st round of calculations, sum is " + s);
        }
        System.out.print("Final result is ");
        switch (s) {
            case "1":
                System.out.println("One");
                break;
            case "2":
                System.out.println("Two");
                break;
            case "3":
                System.out.println("Three");
                break;
            case "4":
                System.out.println("Four");
                break;
            default:
                System.out.println(s);
        }
    }
}
