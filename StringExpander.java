/***Given a string containing characters followed by digits, expand each
character by repeating it according to the digit that follows.
Example 1:
● Input: "a1b4c3"
● Output: "abbbbccc"
● Explanation:
The character 'a' is followed by 1, so it appears once. 
owner: Abhilash
date: 0/9/24*/
import java.util.Scanner;

public class StringExpander{

    public static String expandString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            i++;

            int repeatCount = 0;

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                repeatCount = repeatCount * 10 + (s.charAt(i) - '0'); 
                i++;
            }

            if (repeatCount <= 0) {
                System.err.println("Invalid repeat count for character: " + currentChar);
                continue;
            }

            int j = repeatCount;
            while (j > 0) {
                result.append(currentChar);
                j--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueRunning = true;
            
            while (continueRunning) {
                System.out.println("Enter a string with characters followed by digits (e.g., 'a1b4c3'):");
                String input = scanner.nextLine();

                String expandedString = expandString(input);

                System.out.println("Expanded string:");
                System.out.println(expandedString);

                System.out.println("Do you want to enter another string? (yes/no):");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("no") || response.equals("n")) {
                    continueRunning = false;
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}