import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose Task");
            System.out.println("1. Decimal to All");
            System.out.println("2. Binary to All");
            System.out.println("3. Octal to All");
            System.out.println("4. Hexadecimal to All");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void decimalToAll(Scanner scanner) {
        System.out.print("Enter a positive decimal number (0-9): ");
        String input = scanner.nextLine();
        if (!input.matches("[0-9]")) {
            System.out.println("Invalid input. Please enter a single digit (0-9).");
            return;
        }
        int n = Integer.parseInt(input);
        System.out.println("Decimal: " + n);
        System.out.println("Binary: " + decimalToBinary(n));
        System.out.println("Octal: " + decimalToOctal(n));
        System.out.println("Hexadecimal: " + decimalToHexadecimal(n));
    }

    private static String decimalToBinary(int n) {
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary; // Concatenate the remainder to the front
            n /= 2;
        }
        return binary;
    }

    private static String decimalToOctal(int n) {
        String octal = "";
        while (n > 0) {
            octal = (n % 8) + octal; // Concatenate the remainder to the front
            n /= 8;
        }
        return octal;
    }

    private static String decimalToHexadecimal(int n) {
        String hexadecimal = "";
        while (n > 0) {
            int remainder = n % 16;
            if (remainder < 10) {
                hexadecimal = remainder + hexadecimal; // Concatenate the digit to the front
            } else {
                hexadecimal = (char) ('A' + (remainder - 10)) + hexadecimal; // Concatenate the letter to the front
            }
            n /= 16;
        }
        return hexadecimal;
    }

    private static void binaryToAll(Scanner scanner) {
        System.out.print("Enter a binary number (only 0 and 1): ");
        String binaryStr = scanner.nextLine();
        if (!binaryStr.matches("[01]+")) {
            System.out.println("Invalid input. Please enter a valid binary number.");
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

    private static void octalToAll(Scanner scanner) {
        System.out.print("Enter an octal number (0-7): ");
        String octalStr = scanner.nextLine();
        if (!octalStr.matches("[0-7]+")) {
            System.out.println("Invalid input. Please enter a valid octal number (0-7).");
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

    private static void hexadecimalToAll(Scanner scanner) {
        System.out.print("Enter a hexadecimal number (0-9, A-F): ");
        String hexStr = scanner.nextLine();
        if (!hexStr.matches("[0-9A-Fa-f]+")) {
            System.out.println("Invalid input. Please enter a valid hexadecimal number (0-9, A-F).");
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
                value = Character.toUpperCase(ch) - 'A' + 10; // Handle both uppercase and lowercase
            }
            decimalValue = decimalValue * 16 + value;
        }
        return decimalValue;
    }
}
