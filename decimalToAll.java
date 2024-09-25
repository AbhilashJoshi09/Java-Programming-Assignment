/***Key Concepts
1.Number Systems: The program focuses on three number systems:
Binary (Base 2): Uses digits 0 and 1.
Octal (Base 8): Uses digits 0 to 7.
2.Hexadecimal (Base 16): Uses digits 0 to 9 and letters A to F.
3.Input Handling: The program employs a Scanner to read user input and includes error handling to ensure that only valid positive integers are processed.
4.Array Utilization: Arrays are used to store the digits of the converted numbers before printing them in the correct order.

The code is structured into several key components:
1.Conversion Methods: Three static methods (decToBinary, decToOctal, decTohex) handle the conversion of decimal numbers to their respective bases.
2.Main Method: The entry point of the program, which manages user input and invokes the conversion methods.
3.Error Handling: Utilizes try-catch blocks to manage invalid inputs gracefully.

Owner: Abhilash Joshi;
Date : 25-9-24;
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class decimalToAll {

    static void decToBinary(int n) {
        int[] binaryNum = new int[32];
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
    }

    static void decToOctal(int n) {
        int[] octalNum = new int[32];
        int i = 0;
        while (n > 0) {
            octalNum[i] = n % 8;
            n = n / 8;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            System.out.print(octalNum[j]);
    }

    static void decToHex(int n) {
        int[] hexNum = new int[32];
        int i = 0;
        while (n != 0) {
            hexNum[i] = n % 16;
            n = n / 16;
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            if (hexNum[j] > 9)
                System.out.print((char) (55 + hexNum[j])); // 'A' starts from 10
            else
                System.out.print(hexNum[j]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a positive decimal number or 'exit' to quit: ");
            
            String line = scanner.nextLine();  // Only call nextLine once
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                int n = Integer.parseInt(line);
                
                if (n < 0) {
                    System.out.println("Invalid input. Please enter a valid positive decimal number.");
                    continue;
                }
                
                System.out.println("Decimal - " + n);
                System.out.print("Binary - ");
                decToBinary(n);
                System.out.print("\nOctal - ");
                decToOctal(n);
                System.out.print("\nHexadecimal - ");
                decToHex(n);
                System.out.println();  // For better formatting
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive decimal number.");
            }
        }

        scanner.close();
    }

    public void convert(String input) {
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }
}
