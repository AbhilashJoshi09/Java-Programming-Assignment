/***Given a string s, find the length of the longest substring without repeating characters. */
import java.util.Scanner;


public class LongestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Enter a string: ");
            String s = scanner.nextLine();

            if (s == null) {
                System.out.println("Invalid input! Please enter a valid string.");
            } else {
                Result result = findLongestSubstring(s);
                System.out.println("The length of the longest substring without repeating characters is: " + result.length);
                System.out.println("The longest substring without repeating characters is: " + result.substring);
            }

            System.out.print("Do you want to check another string? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("n")) {
                continueProgram = false;
            } else if (!response.equals("y")) {
                System.out.println("Invalid response! The program will now terminate.");
                continueProgram = false;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }

    private static Result findLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        String longestSubstring = "";

        for (int end = 0; end < n; end++) {
            for (int j = start; j < end; j++) {
                if (s.charAt(end) == s.charAt(j)) {
                    start = j + 1;
                    break;
                }
            }
            int currentLength = end - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstring = s.substring(start, end + 1);
            }
        }

        return new Result(maxLength, longestSubstring);
    }

    // Simple class to hold the result
    private static class Result {
        int length;
        String substring;

        Result(int length, String substring) {
            this.length = length;
            this.substring = substring;
        }
    }
}