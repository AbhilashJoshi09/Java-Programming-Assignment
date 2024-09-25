/***Key Concepts
The program primarily revolves around the following key concepts:
1.Binary Number System: A base-2 numeral system that uses only two digits, 0 and 1.
2.Decimal, Octal, and Hexadecimal Systems: These are base-10, base-8, and base-16 numeral systems, respectively.
3.Recursion: The program employs recursive methods to convert binary numbers to decimal.
4.String Manipulation: The program processes binary strings to separate integer and fractional parts.

Method and Return Type
1.getDecimal(String binaryStr): This method takes a binary string as input and returns its decimal equivalent as a double.
2.power(int base, int exponent): This method calculates the power of a base raised to an exponent and returns an int.
3.getBinaryDecimal(long binary, int exponent): This method converts the integer part of a binary number to decimal and returns a long.
4.getBinaryDecimalFractional(String fractionalBinary, int exponent): This method converts the fractional part of a binary number to decimal and returns a double.
5.binToOct(long getDecimal): This method converts a decimal number to octal and prints the result.
6.binToHexadecimal(long getDecimal): This method converts a decimal number to hexadecimal and prints the result.

Owner: Abhilash Joshi;
Date: 25-9-24;

*/
import java.util.NoSuchElementException;
import java.util.Scanner;

public class binaryToAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");

        try {
            String binaryStr = scanner.nextLine();

            double decimalValue = getDecimal(binaryStr);
            System.out.println("Decimal of " + binaryStr + " is: " + decimalValue);

            // Convert only the integer part to octal and hexadecimal
            long integerPart = (long) decimalValue;
            String octalString = Long.toOctalString(integerPart);
            System.out.println("In octal = " + octalString);

            String hexadecimalString = Long.toHexString(integerPart);
            System.out.println("In hexadecimal = " + hexadecimalString);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException encountered. Please check your input.");
        }
    }

    public static double getDecimal(String binaryStr) {
        if (binaryStr.contains(".")) {
            String[] parts = binaryStr.split("\\.");
            long integerPart = Long.parseLong(parts[0]);
            double fractionalPart = getBinaryDecimalFractional(parts[1], 1);
            return getBinaryDecimal(integerPart, 0) + fractionalPart;
        } else {
            long binary = Long.parseLong(binaryStr);
            return getBinaryDecimal(binary, 0);
        }
    }

    private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    private static long getBinaryDecimal(long binary, int exponent) {
        if (binary == 0) {
            return 0;
        }
        long temp = binary % 10;
        return (temp * power(2, exponent)) + getBinaryDecimal(binary / 10, exponent + 1);
    }

    private static double getBinaryDecimalFractional(String fractionalBinary, int exponent) {
        if (fractionalBinary.isEmpty()) {
            return 0.0;
        }
        double temp = fractionalBinary.charAt(0) - '0';
        return (temp / power(2, exponent)) + getBinaryDecimalFractional(fractionalBinary.substring(1), exponent + 1);
    }

    public static void binToOct(long getDecimal) {
        String octalString = "";
        while (getDecimal != 0) {
            int remainder = (int) (getDecimal % 8);
            octalString = remainder + octalString;
            getDecimal /= 8;
        }
        System.out.println("In octal=" + octalString);
    }

    public static void binToHexadecimal(long getDecimal) {
        String hexadecimalString = "";
        while (getDecimal != 0) {
            int remainder = (int) (getDecimal % 16);
            if (remainder < 10) {
                hexadecimalString = remainder + hexadecimalString;
            } else {
                hexadecimalString = (char) ('A' + (remainder - 10)) + hexadecimalString;
            }
            getDecimal /= 16;
        }
        System.out.println("In hexadecimal=" + hexadecimalString);
    }
   public void convert(String input) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'convert'");
   }
}
