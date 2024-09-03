/***Given a string containing characters followed by digits, expand each
character by repeating it according to the digit that follows.
 */
import java.util.Scanner;

public class StringExpander {
    
    public static String expandString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        Constant constant = new Constant();
        System.out.println(constant.input);

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            i++;
            int repeatCount = 0;

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                repeatCount = repeatCount * 10 + (s.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < repeatCount; j++) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static boolean isValidString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                // Check if the character is a letter
                if (!Character.isLetter(s.charAt(i))) {
                    return false;
                }
            } else {
                // Check if the character is a digit
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
        }
        return s.length() % 2 == 0; // Ensure the string has an even length
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        Constant constant = new Constant();

        do {
            System.out.print(constant.ENTER_STRING);
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("exit")) {
                if (isValidString(userInput)) {
                    String expanded = expandString(userInput);
                    System.out.println("Expanded string: " + expanded);
                } else {
                    System.out.println("This is an incorrect string ");
                    System.out.println("Enter correct string (eg: a2s3f5g)");
                }
            }
        } while (!userInput.equalsIgnoreCase("exit"));

        System.out.println("Exiting the program...");
        scanner.close();
    }
}
