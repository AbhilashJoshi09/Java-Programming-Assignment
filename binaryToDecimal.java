/***Write a Java program that takes an integer in binary format and converts it to its decimal
representation.
1.Binary Number System: A base-2 numeral system that uses only two symbols, typically 0 and 1. Each digit represents a power of 2.
2.Decimal Number System: A base-10 numeral system that uses ten symbols (0-9). It is the standard system for denoting integer and non-integer numbers.
3.Recursion: A programming technique where a method calls itself to solve a problem.

1.isBinary: Validates whether the input string is a binary number.
2.getDecimal: Initiates the conversion process.
3.power: Computes the power of a number using recursion.
4.getBinaryDecimal: Recursively converts the binary number to decimal.
5.main: The entry point of the program, handling user input and output.

Owner: Abhilash Joshi;
Date : 11-9-24;
*/


import java.util.Scanner;

public class binaryToDecimal {
    
    private static boolean isBinary(String str) {
        for (char ch : str.toCharArray()) {
            if (ch != '0' && ch != '1') {
                return false;
            }
        }
        return true;
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
        System.out.print("Enter a binary number: ");
        String binaryInputStr = scanner.nextLine();
        
        if (!isBinary(binaryInputStr)) {
            System.out.println("Invalid input. Please enter a valid binary number.");
            return;
        }
        long binaryInput = Long.parseLong(binaryInputStr);
        System.out.println("Decimal of " + binaryInput + " is: " + getDecimal(binaryInput));
    }
}
