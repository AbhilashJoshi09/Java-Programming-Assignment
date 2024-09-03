/*** Write a Java program that takes a string input and outputs the frequency of
each character in a compressed form.
owner:Abhilash
date:3/9/24
*/
import java.util.Scanner;

public class CharacterFrequencyCompressor {

    public static String compressString(String s) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        
        // Length of the input string
        int n = s.length();
        
        // Check for empty string
        if (n == 0) {
            return "";
        }
        
        // Initialize current character and count
        char currentChar = s.charAt(0);
        int count = 1;
        
        // Iterate over the string starting from the second character
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == currentChar) {
                // Same character, increment count
                count++;
            } else {
                // Different character, append the previous character and count
                result.append(currentChar).append(count);
                // Update current character and reset count
                currentChar = c;
                count = 1;
            }
        }
        
        // Append the last character and count
        result.append(currentChar).append(count);
        
        // Convert StringBuilder to String and return
        return result.toString();
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Enter a string to compress:");
        String input = scanner.nextLine();
        
        // Close the scanner
        scanner.close();
        
        // Compress the string
        String compressedString = compressString(input);
        
        // Output the result
        System.out.println("Compressed string:");
        System.out.println(compressedString);
    }
}
