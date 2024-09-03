import java.util.Scanner;

public class StringExpander {

    public static String expandString(String s) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        
        // Index to traverse through the string
        int i = 0;
        
        // Traverse the input string
        while (i < s.length()) {
            // Get the current character
            char currentChar = s.charAt(i);
            i++;  // Move to the next character which should be a digit
            
            // Initialize a variable to hold the number of repetitions
            int repeatCount = 0;
            
            // Read the digit(s) following the character
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                repeatCount = repeatCount * 10 + (s.charAt(i) - '0');
                i++;
            }
            
            // Append the repeated character to the result
            for (int j = 0; j < repeatCount; j++) {
                result.append(currentChar);
            }
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Enter a string with characters followed by digits (e.g., 'a1b4c3'):");
        String input = scanner.nextLine();
        
        // Close the scanner
        scanner.close();
        
        // Expand the string
        String expandedString = expandString(input);
        
        // Output the result
        System.out.println("Expanded string:");
        System.out.println(expandedString);
    }
}