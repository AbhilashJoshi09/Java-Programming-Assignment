/***Key Concepts
The program is structured around several key concepts:
1.Octal Number System: A base-8 numeral system that uses digits from 0 to 7.
2.Conversion Methods: The program includes methods to convert octal numbers to binary, decimal, and hexadecimal formats.
3.Error Handling: The program incorporates error handling to manage invalid inputs gracefully.

Code Structure
The code is organized into a single class named octalToAll, which contains:Constants for octal number values.
Methods for conversion: octalToBinary, octalToDecimal, octalToHexadecimal, and a helper method power.
A main method that serves as the entry point for user interaction.

Owner: Abhilash Joshi;
Date : 25-9-24;
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class octalToAll {
    private static final long[] octal_numvalues = {000, 001, 010, 011, 100, 101, 110, 111};

    public static long octalToBinary(long octal_num) {
        long tempoctal_num, binary_num, place;
        int rem;
        tempoctal_num = octal_num;
        binary_num = 0;
        place = 1;

        while (tempoctal_num != 0) {
            rem = (int) (tempoctal_num % 10);
            if (rem > 7) {
                System.out.println("Invalid input. Please enter a valid octal number.");
                return -1;
            }
            binary_num += octal_numvalues[rem] * place;
            tempoctal_num /= 10;
            place *= 1000;
        }
        return binary_num;
    }

    public static long octalToDecimal(long octal_num) {
        long decimal_num = 0;
        int i = 0;

        while (octal_num != 0) {
            decimal_num = decimal_num + (octal_num % 10) * power(8, i++);
            octal_num = octal_num / 10;
        }

        return decimal_num;
    }

    public static long power(long base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    public static String octalToHexadecimal(long octal_num) {
        long decimal_num = octalToDecimal(octal_num);

        String hex = "";
        while (decimal_num != 0) {
            long remainder = decimal_num % 16;
            if (remainder < 10)
                hex = remainder + hex;
            else
                hex = (char) (55 + remainder) + hex;
            decimal_num = decimal_num / 16;
        }
        return hex.isEmpty() ? "0" : hex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long octal_num;
        int choice;
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter any octal number (or 'exit' to quit): ");
            String input = in.next();

            if (input.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            try {
                octal_num = Long.parseLong(input);
                if (!isValidOctal(input)) {
                    System.out.println("Invalid input. Please enter a valid octal number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric octal number.");
                continue;
            }

            System.out.println("1. Convert octal to binary");
            System.out.println("2. Convert octal to decimal");
            System.out.println("3. Convert octal to hexadecimal");
            System.out.print("Enter your choice: ");

            try {
                choice = in.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please enter a valid option (1-3).");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                in.next();  // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Equivalent binary number: " + octalToBinary(octal_num));
                    break;
                case 2:
                    System.out.println("Equivalent decimal number: " + octalToDecimal(octal_num));
                    break;
                case 3:
                    System.out.println("Equivalent hexadecimal number: " + octalToHexadecimal(octal_num));
                    break;
            }
        }
        in.close();
    }

    // Helper method to validate octal number (digits must be 0-7)
    private static boolean isValidOctal(String octalStr) {
        for (char c : octalStr.toCharArray()) {
            if (c < '0' || c > '7') {
                return false;
            }
        }
        return true;
    }

    public void convert(String input) {
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }
    
}

