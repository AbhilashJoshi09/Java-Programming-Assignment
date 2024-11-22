/***Key Concepts
1.Recursion: A programming technique where a method calls itself to solve a problem. 
It is particularly useful for tasks that can be broken down into smaller, similar sub-tasks.
2.BigInteger: A class in Java that allows for mathematical operations on integers larger than the maximum value of primitive data types.
3.String Manipulation: The program includes methods to manipulate strings, such as converting formats and counting specific characters.
4.Base Cases: Essential in recursive methods to prevent infinite loops and to provide a stopping condition. 


Code Structure
The program is structured into several methods, each responsible for a specific task.
 The main method, which is not shown, would typically invoke the choose() method to present options to the user. 
 Each task is implemented as follows:

Task 1: Count Palindromes (not yet implemented)
Task 2: Calculate Fibonacci numbers using tail recursion.
Task 3: Convert a string from snake_case to camelCase.
Task 4: Count consonants in a given string using recursion.
Task 5: Convert a binary number to its decimal equivalent using recursion.

Fibonacci Calculation
The Fibonacci calculation is performed using a tail-recursive method, which optimizes performance by reducing the call stack size.

Snake to Camel Case Conversion
This method converts a string from snake_case to camelCase by capitalizing the first letter of each word following a space or special character.

Consonant Counting
The consonant counting method recursively checks each character in the string and increments a counter if the character is a consonant.

Binary to Decimal Conversion
This method converts a binary number to decimal using recursion, breaking down the binary number into its constituent parts.

Owner: Abhilash Joshi;
Date: 12-9-24;

*/

import java.math.BigInteger;
import java.util.Scanner;

public class recursionTask {

    static constant constant = new constant();

    public static void choose() {
        System.out.println(constant.choiceOptions);
    }

    // Method stubs for incomplete tasks
    public static void countPalindromes(String args[]) {
        // not completed;
    }

    // Tail recursion method for better time complexity.
    private static BigInteger fibonacciTail(int index, BigInteger prev, BigInteger current) {
        if (index == 0) {
            return prev;
        }
        return fibonacciTail(index - 1, current, prev.add(current));
    }

    public static BigInteger fibonacci(int n) {
        return fibonacciTail(n, BigInteger.ZERO, BigInteger.ONE);
    }

    // Task 3: SnakeToCamel
    public static String convertString(String input) {
        return convertStringHelper(input, 0, "", true,true);
    }

    private static String convertStringHelper(String input, int index, String result, boolean capitalizeNext, boolean isFirst) {
        if (index >= input.length()) {
            return result;
        }
        

        char currentChar = input.charAt(index);
        if (currentChar == ' ' || currentChar == '!' || currentChar == '@' || currentChar == '#' ||
                currentChar == '$' || currentChar == '%' || currentChar == '^' || currentChar == '&' ||
                currentChar == '*' || currentChar == '-' || currentChar == '_' || currentChar == '=' ||
                currentChar == '+') {
            capitalizeNext = true;
        } else if (Character.isLetter(currentChar)) {
            if (capitalizeNext) {
                if (isFirst) {
                    result += Character.toLowerCase(currentChar);
                    isFirst = false;
                } else {
                    result += Character.toUpperCase(currentChar);
                }
                capitalizeNext = false;
            } else {
                result += Character.toLowerCase(currentChar);
            }
        }

        return convertStringHelper(input, index + 1, result, capitalizeNext, isFirst);
    }

    // Task 4: CountConsonants
    static int consonantCount = 0;

    public static void consonantCount(String input, int index) {
        if (index == input.length()) {
            return;
        }

        char character = Character.toLowerCase(input.charAt(index));
        if (character >= 'a' && character <= 'z' && !(character == 'a' || character == 'e' || character == 'i'
                || character == 'o' || character == 'u')) {
            consonantCount++;
        }
        consonantCount(input, index + 1);
    }

    // Task 5: BinaryToDecimal
    private static boolean isBinary(String str, int index) {
        if (index >= str.length()) {
            return true;
        }
        if (str.charAt(index) != '0' && str.charAt(index) != '1') {
            return false;
        }
        return isBinary(str, index + 1);
    }

    public static long getDecimal(long binary) {
        return getBinaryDecimal(binary, 0);
    }

    private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    private static long getBinaryDecimal(long binary, int exponent) {
        if (binary == 0) {
            return 0;
        } else {
            long temp = binary % 10;
            return (temp * power(2, exponent)) + getBinaryDecimal(binary / 10, exponent + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choose();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Implement Task 1: CountPalindromes
                    break;

                case 2:
                    do {
                        System.out.print(constant.indexValue);
                        String input = scanner.nextLine();

                        try {
                            int n = Integer.parseInt(input);
                            if (n < 0) {
                                System.out.println(constant.invalid_input);
                            } else {
                                System.out.println("Fibonacci number at index " + n + " is: " + fibonacci(n));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(constant.invalid_input);
                        }
                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 3:
                    do {
                        System.out.println(constant.snakeCase);
                        String input = scanner.nextLine();
                        if (input.isEmpty() || Character.isDigit(input.charAt(0))) {
                            System.out.println(constant.invalid_input);
                        } else {
                            System.out.println("Converted String: " + convertString(input));
                        }
                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 4:
                    do {
                        System.out.println(constant.consonantString);
                        String input = scanner.nextLine();
                        consonantCount(input, 0);
                        System.out.println("Consonants: " + consonantCount);
                        // Reset consonantCount for next input
                        consonantCount = 0;
                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 5:
                    do {
                        System.out.print(constant.binaryinput);
                        String binaryInputStr = scanner.nextLine();

                        try {
                            if (binaryInputStr.isEmpty() || !isBinary(binaryInputStr, 0)) {
                                System.out.println(constant.invalid_input);
                                continue;
                            }
                            long binaryInput = Long.parseLong(binaryInputStr);
                            System.out.println("Decimal of " + binaryInputStr + " is: " + getDecimal(binaryInput));
                        } catch (NumberFormatException e) {
                            System.out.println(constant.invalid_input);
                            e.printStackTrace();
                        }

                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println(constant.invalid_choice);
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
