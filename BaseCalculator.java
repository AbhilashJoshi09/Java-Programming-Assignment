/***The BaseCalculator class is a Java program that allows users to perform arithmetic operations on numbers represented in various bases (binary, octal, decimal, and hexadecimal). 
 * The user can enter numbers in a specified base, choose an arithmetic operation, and then receive the result in another specified base. 
 * Owner: Abhilash Joshi; 
 * Date: 26-9-24 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseCalculator {
    public static void main(String[] args) {
        Constant constant = new Constant();

        Scanner scanner = new Scanner(System.in);
        String exit = "exit";

        while (true) {
            try {
                System.out.print(Constant.FIRST_BASE);
                String inputBase1 = scanner.next();
                if (inputBase1.equalsIgnoreCase(exit)) {
                    break;
                }
                int base1 = Integer.parseInt(inputBase1);
                if (base1 < 2 || base1 > 16) {
                    throw new InputMismatchException(Constant.INVALID_BASE);
                }

                System.out.print(Constant.FIRST_NUM);
                String num1Str = scanner.next();
                int num1 = convertToDecimal(num1Str, base1);
                System.out.print(Constant.SECOND_BASE);
                String inputBase2 = scanner.next();
                if (inputBase2.equalsIgnoreCase(exit)) {
                    break;
                }
                int base2 = Integer.parseInt(inputBase2);
                if (base2 < 2 || base2 > 16) {
                    throw new InputMismatchException(Constant.INVALID_BASE);
                }
                System.out.print(Constant.SECOND_NUM);
                String num2Str = scanner.next();
                int num2 = convertToDecimal(num2Str, base2);

                System.out.print(Constant.RESULT_BASE);
                String inputResultBase = scanner.next();
                if (inputResultBase.equalsIgnoreCase(exit)) {
                    break;
                }
                int resultBase = Integer.parseInt(inputResultBase);
                if (resultBase < 2 || resultBase > 16) {
                    throw new InputMismatchException(Constant.INVALID_BASE);
                }

                System.out.print(Constant.OPERATIONS);
                char operation = scanner.next().charAt(0);

                int result = 0;
                switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new InputMismatchException("Unsupported operation");
                }

                String resultStr = convertToBase(result, resultBase);
                System.out.println("The result in base " + resultBase + " is: " + resultStr);
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Method to convert a number from decimal to a specified base
    /***Inputs
     * int num:
     * This parameter represents the integer number that you want to convert to the specified base. It can be positive or negative.
     * int base:
     * This parameter specifies the base to which the number should be converted. It must be an integer value ranging from 2 to 16. The bases represent the numeral systems:
     * Base 2: Binary, Base 8: Octal, Base 10: Decimal, Base 16: Hexadecimal 
     * Return Value:
     * The method returns a String that represents the original integer (num) in the specified base (base). 
     * The returned string may include characters from '0' to '9' for values 0-9 and 'A' to 'F' for values 10-15 (for bases greater than 10).
     * If the input number is negative, the resulting string will have a '-' sign prefixed.
     * */ 
    public static String convertToBase(int num, int base) {
        StringBuilder result = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);

        do {
            int remainder = num % base;
            if (remainder >= 10) {
                result.append((char) ('A' + (remainder - 10)));
            } else {
                result.append(remainder);
            }
            num /= base;
        } while (num > 0);

        if (isNegative) {
            result.append('-');
        }

        return result.reverse().toString();
    }

    // Method to convert a number from a specified base to decimal
    /***Inputs
     * String numStr:
     * This parameter is a string representation of the number to be converted. It can contain digits (0-9) and letters (A-F) for bases higher than 10. It is expected to be a positive number (i.e., it should not start with a '-').
     * int base:
     * This parameter specifies the base of the input number, which can range from 2 to 16.
     * Return Value:
     * The method returns an int that represents the decimal value of the input number.
     *  */
    public static int convertToDecimal(String numStr, int base) {
        if (numStr.charAt(0) == '-') {
            throw new InputMismatchException(Constant.NEGATIVE_INP);
        }

        int num = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);

            if (digit >= 'a' && digit <= 'f') {
                digit = (char) (digit - 'a' + 'A');
            }

            int value;
            if (digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                value = digit - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Invalid character in number: " + digit);
            }

            if (value >= base) {
                throw new IllegalArgumentException("Digit " + digit + " is not valid for base " + base);
            }

            if (base == 2 && (digit != '0' && digit != '1')) {
                throw new IllegalArgumentException(Constant.INVALIDE_BINARY);
            }

            if (base == 8 && (digit < '0' || digit > '7')) {
                throw new IllegalArgumentException(Constant.INVALID_OCTAL);
            }

            if (base == 10 && (digit < '0' || digit > '9')) {
                throw new IllegalArgumentException(Constant.INVALID_DECIMAL);
            }

            num = num * base + value;
        }
        return num;
    }

}
