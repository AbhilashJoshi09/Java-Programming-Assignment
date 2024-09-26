/*** The Java program, NumberConverter, is a comprehensive tool that allows users to convert numbers between various numeral systems: decimal, binary, octal, and hexadecimal.
 *  Below is a detailed explanation of how the program works, including its structure, functionality, and methods.
 * Owner: Abhilash Joshi;
 *  Date: 26-9-24;*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberConverter {
    Constant constant =  new Constant();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(Constant.SELECT_OPTION);
            
            while (!scanner.hasNextInt()) {
                System.out.println(Constant.INVALID_INP);
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            case 1:
                decimalToAll(scanner);
                break;
            case 2:
                binaryToAll(scanner);
                break;
            case 3:
                octalToAll(scanner);
                break;
            case 4:
                hexadecimalToAll(scanner);
                break;

            case 5:
                BaseCalculator.main(args);
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println(Constant.INVALID_INP);
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void decimalToAll(Scanner scanner) {
        System.out.print(Constant.DECIMAL_NUM);
        String input = scanner.nextLine();
        try {
            int n = Integer.parseInt(input);
            System.out.println("Decimal: " + n);
            System.out.println("Binary: " + decimalToBinary(n));
            System.out.println("Octal: " + decimalToOctal(n));
            System.out.println("Hexadecimal: " + decimalToHexadecimal(n));
        } catch (NumberFormatException e) {
            System.out.println(Constant.Negative_NUM_INP);
        }
    }

    /***Input:
     * The function takes a single integer parameter n, which is the decimal number to be converted.
     * Return:
     * Once n becomes 0, the loop exits, and the function returns the binary string, which now contains the binary representation of the original decimal number. */
    private static String decimalToBinary(int n) {
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary;
            n /= 2;
        }
        return binary;
    }

    /***Input:
     * The function takes a single integer parameter n, which is the decimal number to be converted to octal. 
     * It initializes an empty string octal to store the octal representation.
     * Return:
     * Once n becomes 0, the loop exits, and the function returns the octal string, which now contains the octal representation of the original decimal number.*/
    private static String decimalToOctal(int n) {
        String octal = "";
        while (n > 0) {
            octal = (n % 8) + octal;
            n /= 8;
        }
        return octal;
    }

    /***Input:
     * The function takes a single integer parameter n, which is the decimal number to be converted to hexadecimal. 
     * Return:
     * Once n becomes 0, the loop exits, and the function returns the hexadecimal string, which now contains the hexadecimal representation of the original decimal number.*/
    private static String decimalToHexadecimal(int n) {
        String hexadecimal = "";
        while (n > 0) {
            int remainder = n % 16;
            if (remainder < 10) {
                hexadecimal = remainder + hexadecimal;
            } else {
                hexadecimal = (char) ('A' + (remainder - 10)) + hexadecimal;
            }
            n /= 16;
        }
        return hexadecimal;
    }
    /***Input:
     * The method takes a binary string binaryStr as input.
     * Return:After processing all characters in the binary string, it returns the computed decimalValue.*/
    private static void binaryToAll(Scanner scanner) {
        System.out.print(Constant.BINARY_NUM);
        String binaryStr = scanner.nextLine();
        if (binaryStr.length() > 12) {
            System.out.println(Constant.NUMBER_VALUE12);
            return;
        }
        if (!binaryStr.matches("[01]+")) {
            System.out.println(Constant.BINARY_INP);
            return;
        }
        int decimalValue = binaryToDecimal(binaryStr);
        System.out.println("Decimal: " + decimalValue);
        System.out.println("Octal: " + decimalToOctal(decimalValue));
        System.out.println("Hexadecimal: " + decimalToHexadecimal(decimalValue));
    }

    private static int binaryToDecimal(String binaryStr) {
        int decimalValue = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            decimalValue = decimalValue * 2 + (binaryStr.charAt(i) - '0');
        }
        return decimalValue;
    }


    /***Input:
     * The method takes a string octalStr representing the octal number.
     * Return:
     * After processing all characters in the octal string, it returns the computed decimalValue. */
    private static void octalToAll(Scanner scanner) {
        System.out.print(Constant.OCTAL_NUM);
        String octalStr = scanner.nextLine();
        if (!octalStr.matches("[0-7]+")) {
            System.out.println(Constant.OCTAL_INP);
            return;
        }
        int decimalValue = octalToDecimal(octalStr);
        System.out.println("Decimal: " + decimalValue);
        System.out.println("Binary: " + decimalToBinary(decimalValue));
        System.out.println("Hexadecimal: " + decimalToHexadecimal(decimalValue));
    }

    private static int octalToDecimal(String octalStr) {
        int decimalValue = 0;
        for (int i = 0; i < octalStr.length(); i++) {
            decimalValue = decimalValue * 8 + (octalStr.charAt(i) - '0');
        }
        return decimalValue;
    }


    /***Input:
     * The method takes a string hexStr representing the hexadecimal number.
     * Return:
     * After processing all characters in the hexadecimal string, it returns the computed decimalValue. */
    private static void hexadecimalToAll(Scanner scanner) {
        System.out.print(Constant.HEXADECIMAL_NUM);
        String hexStr = scanner.nextLine();
        if (hexStr.length() > 12) {
            System.out.println(Constant.NUMBER_VALUE12);
            return;
        }
        if (!hexStr.matches("[0-9A-Fa-f]+")) {
            System.out.println(Constant.HEXADECIMAL_INP);
            return;
        }
        int decimalValue = hexadecimalToDecimal(hexStr);
        System.out.println("Decimal: " + decimalValue);
        System.out.println("Binary: " + decimalToBinary(decimalValue));
        System.out.println("Octal: " + decimalToOctal(decimalValue));
    }

    private static int hexadecimalToDecimal(String hexStr) {
        int decimalValue = 0;
        for (int i = 0; i < hexStr.length(); i++) {
            char ch = hexStr.charAt(i);
            int value;
            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            } else {
                value = Character.toUpperCase(ch) - 'A' + 10;
            }
            decimalValue = decimalValue * 16 + value;
        }
        return decimalValue;
    }
}
