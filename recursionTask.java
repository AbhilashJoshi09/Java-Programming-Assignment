
/***Key Concepts
1.Recursion: A programming technique where a method calls itself to solve a problem. 
It is particularly useful for tasks that can be broken down into smaller, similar sub-tasks.
2.BigInteger: A class in Java that allows for mathematical operations on integers larger than the maximum value of primitive data types.
3.String Manipulation: The program includes methods to manipulate strings, such as converting formats and counting specific characters.
4.Base Cases: Essential in recursive methods to prevent infinite loops and to provide a stopping condition. 


Code Structure
The program is structured into several methods, each responsible for a specific task.
 The main method, which is not shown, would typically invoke the choose() method to present options to the user. 
 Each task is implemented as follows:

Task 1: Count Palindromes.
Task 2: Calculate Fibonacci numbers using tail recursion.
Task 3: Convert a string from snake_case to camelCase.
Task 4: Count consonants in a given string using recursion.
Task 5: Convert a binary number to its decimal equivalent using recursion.

Task 1: Count Palindromes.
1.Palindrome: A string that reads the same forwards and backwards, such as "racecar" or "level".
2.Unique Substrings: Substrings that are distinct from one another, meaning no two substrings are identical.
3.Recursion: A programming technique where a method calls itself to solve smaller instances of the same problem.
4Boolean Array: An array used to track whether a specific substring has been encountered before, ensuring uniqueness.

The code is structured into several methods:

-getUniquePalindromeCount(String inputString): The main method that initializes the process.
-palindromeCombinations(String inputString, int startIndex, int endIndex): A recursive method that generates all possible substrings and checks for palindromes.
-calculateUniqueIndex(String substring, String inputString): A helper method that computes a unique index for each substring.
-isPalindrome(String inputString): A method that checks if a given string is a palindrome.

Task-2.Fibonacci Calculation
The Fibonacci calculation is performed using a tail-recursive method, which optimizes performance by reducing the call stack size.
Method Breakdown:
1.fibonacciTail(int index, BigInteger prev, BigInteger current):

2.Parameters:
  index: The position in the Fibonacci sequence to compute.
  prev: The Fibonacci number at the previous index.
  current: The Fibonacci number at the current index.
   Return Type: Returns a BigInteger representing the Fibonacci number at the specified index.
      fibonacci(int n):

3.Parameters:
    n: The index of the Fibonacci number to compute.
     Return Type: Calls fibonacciTail with initial values and returns the result.

Task-3Snake to Camel Case Conversion
This method converts a string from snake_case to camelCase by capitalizing the first letter of each word following a space or special character.
The code consists of two main methods:
1.convertString(String input): This is the public method that initiates the conversion process.
2.convertToCamel(String input, int index, String result, boolean capitalizeNext, boolean isFirst): This private method performs the actual conversion using recursion.

Task-4.Consonant Counting
The consonant counting method recursively checks each character in the string and increments a counter if the character is a consonant.
1.Base Case: The recursion stops when the index equals the length of the input string.
2.Character Evaluation: The method checks if the current character is a consonant by:
Converting the character to lowercase.
Verifying if it falls within the range of alphabetic characters.
Ensuring it is not a vowel.
3.Recursive Call: The method calls itself with the next index to continue the evaluation of the string

Task-5.Binary to Decimal Conversion
This method converts a binary number to decimal using recursion, breaking down the binary number into its constituent parts.
Method Explanations
1.isBinary(String str, int index): This method checks if the string str is a valid binary string.

2.getDecimal(String binaryStr): This method converts a binary string to a decimal value. It handles both integer and fractional parts. 
If the string contains a '.', it splits the string and processes each part separately. The method returns a double representing the decimal value.

3.power(int base, int exponent): This method calculates the power of a number recursively. It returns multiplies the base by the result of the method called with the exponent decremented by one.

4.getBinaryDecimal(long binary, int exponent): This method converts the integer part of a binary string to decimal. It recursively processes each digit, multiplying it by the appropriate power of 2 based on its position.

5.getBinaryDecimalFractional(String fractionalBinary, int exponent): This method converts the fractional part of a binary string to decimal. It processes each digit, dividing it by the appropriate power of 2, and recursively calls itself for the remaining digits.

Owner: Abhilash Joshi;
Date: 13-9-24;

*/

import java.math.BigInteger;
import java.util.Scanner;

public class recursionTask {

    static constant constant = new constant();

    public static void choose() {
        System.out.println(constant.choiceOptions);
    }

    // Method stubs for incomplete tasks
    private static int uniquePalindromeCount = 0;
    private static boolean[] isPalindromeUnique;
    private static final int MAX_INPUT_LENGTH = 25;

    private static void palindromeCombinations(String inputString, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        String currentSubstring = inputString.substring(startIndex, endIndex + 1);
        if (isPalindrome(currentSubstring)) {
            int uniqueIndex = calculateUniqueIndex(currentSubstring, inputString);
            if (!isPalindromeUnique[uniqueIndex]) {
                isPalindromeUnique[uniqueIndex] = true;
                uniquePalindromeCount++;
            }
        }

        palindromeCombinations(inputString, startIndex + 1, endIndex);
        palindromeCombinations(inputString, startIndex, endIndex - 1);
    }

    private static int calculateUniqueIndex(String substring, String inputString) {
        int length = substring.length();
        return (inputString.length() - length) * (inputString.length() - length + 1) / 2 + inputString.indexOf(substring);
    }

    private static boolean isPalindrome(String inputString) {
        if (inputString.length() <= 1) {
            return true;
        }

        if (inputString.charAt(0) != inputString.charAt(inputString.length() - 1)) {
            return false;
        }

        return isPalindrome(inputString.substring(1, inputString.length() - 1));
    }

    // Tail recursion method for better time complexity.
    // and we can also use array to store the value and then print the fibonacci
    // sequence
    // like(return[intput] = fibonacci[n -1] + fibonacci[n -2];)
    private static BigInteger fibonacciTail(int index, BigInteger prev, BigInteger current) {
        if (index == 0) {
            return prev;
        }
        return fibonacciTail(index - 1, current, prev.add(current));
    }

    public static String fibonacci(int n) {
        BigInteger result = fibonacciTail(n, BigInteger.ZERO, BigInteger.ONE);
        String resultStr = result.toString();
        if (resultStr.length() > 12) {
            resultStr = resultStr.substring(0, 12);
            return resultStr;
        }
        return resultStr;
    }

    // Task 3: SnakeToCamel
    public static String convertString(String input) {
        if (isCamelCase(input, 0, false)) {
            return input;
        }
        return convertToCamel(input, 0, "", true, true);
    }

    private static boolean isCamelCase(String input, int index, boolean foundUpper) {
        if (index >= input.length()) {
            return true;
        }

        char currentChar = input.charAt(index);

        if (Character.isUpperCase(currentChar)) {
            foundUpper = true;
        }

        if (foundUpper && (currentChar == ' ' || currentChar == '!' || currentChar == '@' || currentChar == '#' ||
                currentChar == '$' || currentChar == '%' || currentChar == '^' || currentChar == '&' ||
                currentChar == '*' || currentChar == '-' || currentChar == '_' || currentChar == '=' ||
                currentChar == '+')) {
            return false;
        }

        return isCamelCase(input, index + 1, foundUpper);
    }

    private static String convertToCamel(String input, int index, String result, boolean capitalizeNext,
            boolean isFirst) {
        if (index >= input.length()) {
            return result;
        }

        char currentChar = input.charAt(index);
        if (currentChar == ' ' || currentChar == '!' || currentChar == '@' || currentChar == '#' ||
                currentChar == '$' || currentChar == '%' || currentChar == '^' || currentChar == '&' ||
                currentChar == '*' || currentChar == '-' || currentChar == '_' || currentChar == '=' ||
                currentChar == '+') {
            capitalizeNext = true;
        } else if (Character.isLetter(currentChar)) {
            if (capitalizeNext) {
                if (isFirst) {
                    result += Character.toLowerCase(currentChar);
                    isFirst = false;
                } else {
                    result += Character.toUpperCase(currentChar);
                }
                capitalizeNext = false;
            } else {
                result += Character.toLowerCase(currentChar);
            }
        }

        return convertToCamel(input, index + 1, result, capitalizeNext, isFirst);
    }

    // Task 4: CountConsonants
    static int consonantCount = 0;

    public static void consonantCount(String input, int index) {
        if (index == input.length()) {
            return;
        }

        char character = Character.toLowerCase(input.charAt(index));
        if (character >= 'a' && character <= 'z' && !(character == 'a' || character == 'e' || character == 'i'
                || character == 'o' || character == 'u')) {
            consonantCount++;
        }
        consonantCount(input, index + 1);
    }

    // Task 5: BinaryToDecimal
    private static boolean isBinary(String str, int index) {
        if (index >= str.length()) {
            return true;
        }
        char c = str.charAt(index);
        if (c != '0' && c != '1' && c != '.') {
            return false;
        }
        return isBinary(str, index + 1);
    }

    public static double getDecimal(String binaryStr) {
        if (binaryStr.contains(".")) {
            String[] parts = binaryStr.split("\\.");
            double integerPart = getBinaryDecimal(parts[0], 0);
            double fractionalPart = getBinaryDecimalFractional(parts[1], 1);
            return integerPart + fractionalPart;
        } else {
            return getBinaryDecimal(binaryStr, 0);
        }
    }

    private static double getBinaryDecimal(String binary, int exponent) {
        if (binary.isEmpty()) {
            return 0;
        }
        char lastChar = binary.charAt(binary.length() - 1);
        double lastDigit = lastChar - '0';
        return (lastDigit * power(2, exponent))
                + getBinaryDecimal(binary.substring(0, binary.length() - 1), exponent + 1);
    }

    private static double getBinaryDecimalFractional(String fractionalBinary, int exponent) {
        if (fractionalBinary.isEmpty()) {
            return 0.0;
        }
        double temp = fractionalBinary.charAt(0) - '0';
        return (temp / power(2, exponent)) + getBinaryDecimalFractional(fractionalBinary.substring(1), exponent + 1);
    }

    private static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    private static long getBinaryDecimal(long binary, int exponent) {
        if (binary == 0) {
            return 0;
        }
        long temp = binary % 10;
        return (temp * power(2, exponent)) + getBinaryDecimal(binary / 10, exponent + 1);
    }

    private static double getBinaryDecimalFractional(String fractionalBinary, long exponent) {
        if (fractionalBinary.isEmpty()) {
            return 0.0;
        }
        double temp = fractionalBinary.charAt(0) - '0';
        return (temp / power(2, exponent)) + getBinaryDecimalFractional(fractionalBinary.substring(1), exponent + 1);
    }
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choose();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    do {
                        System.out.print("Enter a string: ");
                        String inputString = scanner.nextLine();
                        
                        if (inputString.length() > MAX_INPUT_LENGTH) {
                            System.out.println("Invalid input");
                            return;
                        }
                        isPalindromeUnique = new boolean[inputString.length() * (inputString.length() + 1) / 2];
                        palindromeCombinations(inputString, 0, inputString.length() - 1);
                        System.out.println("Number of unique palindromic combinations: " + uniquePalindromeCount);

                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 2:
                    do {
                        System.out.println(constant.indexValue);
                        String input = scanner.nextLine();
                        
                         try {
                            int n = Integer.parseInt(input);
                            if (n < 0) {
                                 System.out.println(constant.invalid_input);
                                } else {
                                    System.out.println(constant.fibonacciResult + n + " is: " + fibonacci(n));
                                }
                                 } catch (NumberFormatException e) {
                                    System.out.println(constant.invalid_input);
                                }
                                System.out.print(constant.promptwagin); 
                            } while (scanner.nextLine().equalsIgnoreCase("yes"));
                            break;

                case 3:
                    do {
                        System.out.println(constant.snakeCase);
                        String input = scanner.nextLine();
                        String result = convertString(input);
                        System.out.println(constant.convertedResult + result);
                        System.out.print(constant.promptwagin); 
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 4:
                    do {
                        System.out.println(constant.consonantString);
                        String input = scanner.nextLine();
                        consonantCount(input, 0);
                        System.out.println(constant.consonantResult + consonantCount);
                        
                        consonantCount = 0;
                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 5:
                    do {
                        System.out.print(constant.binaryinput);
                        String binaryInputStr = scanner.nextLine();
                        if (binaryInputStr.isEmpty() || !isBinary(binaryInputStr, 0)) {
                            System.out.println(constant.invalid_input);
                        } else {
                            try {
                                double decimalValue = getDecimal(binaryInputStr);
                                System.out.println(constant.binaryResult + binaryInputStr + " is: " + decimalValue);
                            } catch (NumberFormatException e) {
                                System.out.println(constant.invalid_input);
                                e.printStackTrace();
                            }
                        }

                        System.out.print(constant.promptwagin);
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));
                    break;

                case 6:
                    System.out.println(constant.exit);
                    break;

                default:
                    System.out.println(constant.invalid_choice);
                    break;
            }
        }while(choice!=6);

    scanner.close();
}

}
