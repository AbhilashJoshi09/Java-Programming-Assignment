/***The available operations are
listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its
respective operation based on the user's input.
Owner: AbhilashJoshi
Date: 4/9/24
 */


import java.util.Scanner;

public class StringOperator {

    private static String currentString = "";

    public static void Choose() {
        System.out.println("Choose an operation:");
        System.out.println("1 for Append");
        System.out.println("2 for CountWords");
        System.out.println("3 for Replace");
        System.out.println("4 for isPalindrome");
        System.out.println("5 for Splice");
        System.out.println("6 for Split");
        System.out.println("7 for MaxRepeatingCharacter");
        System.out.println("8 for Sort");
        System.out.println("9 for Shift");
        System.out.println("10 for Reverse");
        System.out.println("Enter the number corresponding to your choice:");
    }

/***Appends the newString provided by the user to the existing string. The
method should remember the appended result.
String currentString = "Hello";
append(" World"); // Result: "Hello World"
 */

    public static String Append_String(String current_string, String newString) {
        currentString += newString;
        System.out.println("Given String: " + currentString);
        return currentString; // Return the updated string
    }


/***Counts the total number of words in the current string.
 * String text = "Hello World from Codeup";
int wordCount = countWords(); // Result: 4
 */    

    public static int CountWords(String input){
        int wordcount = 0;
        boolean inword = false;

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isLetterOrDigit(c)){
                if(!inword){
                    inword = true;
                    wordcount ++;
                }
            }else{
                inword = false;
            }
        }
        return wordcount;
    }


/***Checks if the current string is a palindrome. A palindrome is a word,
phrase, or sequence that reads the same backward as forward.
String text = "madam";
boolean isPal = isPalindrome(); //
 */  

 
    public static String Palindrome(String input) {
        char[] reverseString = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reverseString[i] = input.charAt(input.length() - 1 - i);
        }
        return new String(reverseString); // Return the reversed string
    }

/***Description: Reverses the current string.
 * String reversedText = reverse(); // Result: "avaJ"
 * 
 */

    public static String Reverse(String input) {
        char[] reverseString = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reverseString[i] = input.charAt(input.length() - 1 - i);
        }
        return new String(reverseString);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Choose();
        int choice;
        try {
            choice = scanner.nextInt();  // Read integer choice
            scanner.nextLine(); // Consume newline after the integer input
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.close();
            return; // Exit the program if input is invalid
        }
        
        switch (choice) {
            case 1:
                String input;
                do {
                    System.out.println("Enter String To Append ('No' to exit): ");
                    input = scanner.nextLine();
                    if (!input.equalsIgnoreCase("No")) {
                        currentString = Append_String(currentString, input);
                        System.out.println("Updated String is: " + currentString);
                    }
                    System.out.println("If you want to append more then press Y else No: ");
                    input = scanner.nextLine();
                } while (input.equalsIgnoreCase("Y"));
                break;



            case 2:
                System.out.println("Enter line of text (type 'NO' in new line to exit):");
                while (true) {
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("NO")) {
                        break;
                    }
                    int wordcount = CountWords(input);
                    System.out.println("Number of words: " + wordcount);
                }
                break;



            case 4:
                System.out.println("Enter any Word (Type 'No' to exit):");
                input = scanner.nextLine();  
                if (input.equalsIgnoreCase("No")) {
                    break;
                }

                String reversed = Palindrome(input); // Use the Palindrome method
                if (input.equalsIgnoreCase(reversed)) {
                    System.out.println("String is a Palindrome");
                } else {
                    System.out.println("String is not a Palindrome");
                }
                break;



            case 10:
                System.out.println("Enter A String to Reverse:");
                input = scanner.nextLine();
                String reversedString = Reverse(input);
                System.out.println("Reversed String is: " + reversedString);
                break; 
                
                

            default:
                System.out.println("Invalid choice");
                break;
        }

        scanner.close();
    }
}
