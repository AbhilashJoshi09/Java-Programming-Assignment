/***Key Concepts
1.Hexadecimal System: A base-16 number system that uses digits 0-9 and letters A-F to represent values.
2.BigInteger: A Java class that allows for mathematical operations on integers larger than Long.MAX_VALUE.
3.Input Handling: The program uses a Scanner to read user input and includes error handling to ensure valid hexadecimal strings are processed.
4.Conversion Methods: The program includes methods to convert hexadecimal to decimal, binary, and octal formats. 

The program is structured into a main class hexadecimalToAll with the following components:
1.Main Method: The entry point of the program that handles user input and manages the conversion process.
2.Conversion Methods: Private methods that perform the actual conversions from hexadecimal to decimal, binary, and octal.

Owner: Abhilash Joshi;
Date : 25-9-24;
*/
import java.math.BigInteger;
import java.util.Scanner;

public class hexadecimalToAll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            try {
                System.out.print("Enter a hexadecimal string (or 'exit' to quit): ");
                String hexInput = scanner.nextLine();
				
                if (hexInput.equalsIgnoreCase("exit")) {
                    exit = true;
					scanner.nextLine();
                    continue;
					
                }

                if (hexInput.charAt(0) == '-') {
                    System.out.println("Invalid input. Please enter a valid hexadecimal string or 'exit' to quit.");
                    continue;
                }
                
                for (char c : hexInput.toCharArray()) {
                    if (c < '0' || c > 'f' || (c > '9' && c < 'a')) {
                        System.out.println("Invalid string. Please enter a valid hexadecimal string or 'exit' to quit.");
                        continue;
                    }
                }
                
                BigInteger decimalOutput = hexToDecimal(hexInput);
                String binaryOutput = hexToBinary(hexInput);
                String octalOutput = decimalToOctal(decimalOutput);

                System.out.println("Decimal: " + decimalOutput);
				scanner.nextLine();
                System.out.println("Binary: " + binaryOutput);
				scanner.nextLine();
                System.out.println("Octal: " + octalOutput);
				scanner.nextLine();	

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid hexadecimal string or 'exit' to quit.");
                scanner.nextLine();
            }
        }
        
    }
   
    private static BigInteger hexToDecimal(String hexInput) {
        return new BigInteger(hexInput, 16); 
    }
   
    private static String hexToBinary(String hexInput) {
        String binaryOutput = "";
        for (char c : hexInput.toUpperCase().toCharArray()) {
            if (c < '0' || c > 'F' || (c > '9' && c < 'A')) {
                return "Invalid Hexadecimal String";
            }
            int decimalValue = 0;
            if (c >= '0' && c <= '9') {
                decimalValue = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                decimalValue = c - 'A' + 10;
            }
            binaryOutput += decimalToBinary(decimalValue);
        }
        return binaryOutput;
    }
    
    private static String decimalToBinary(int decimalValue) {
        String binaryOutput = "";
        while (decimalValue != 0) {
            binaryOutput = (decimalValue % 2 == 0 ? '0' : '1') + binaryOutput;
            decimalValue /= 2;
        }
        while (binaryOutput.length() % 4 != 0) {
            binaryOutput = '0' + binaryOutput;
        }
        return binaryOutput;
    }
    
    private static String decimalToOctal(BigInteger decimalValue) {
        return decimalValue.toString(8); 
    }

    public void convert(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }
}

