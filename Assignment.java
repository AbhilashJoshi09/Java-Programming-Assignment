/***bellow file have followling tasks:-
 * Task 1: Valid Parentheses Combination Generator
 * Task 2: Digit Sum Loop(String)
 * Task 3: Consecutive Number Summer
 * Task 4: Caesar Cipher with Shift Variability
 * Task 5: Encoding Challenge with ASCII Conversion
 * 
 * 
 * The program should run automatically once executed, and the user should
   have the option to switch between tasks and execute them as needed.

   Owner :- Abhilash Joshi
   Date :- 10-9-2924
 * 
  */

import java.util.Arrays;
import java.util.Scanner;

public class Assignment {

    static Constant constant = new Constant();

    public static void choose() {
        System.out.println(constant.choiceOptions);
        
    }

//Task 1: Valid Parentheses Combination Generator    
    public static void pairCombination(String input) {
        String[] outputArray = new String[100];
        int count = 0;

        if (input.isEmpty() || input.length() == 1) {
            System.out.print(input);
        } else {
            for (int i = 0; i < input.length(); i++) {
                outputArray[count] = String.valueOf(input.charAt(i));
                count++;
            }

            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < input.length(); j++) {

                    if (i != j) {
                        String combination = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(j));
                        outputArray[count] = combination;
                        count++;
                    }

                }
            }
            boolean found = false;
            for (int k = 0; k < count; k++) {
                if (outputArray[k].equals(input)) {
                    found = true;
                    break;
                }
            }
            if (!found){
            outputArray[count] = String.valueOf(input);
            count++;
            }

            for (int i = 0; i < count; i++) {
                System.out.print(outputArray[i]);
                if (i < count - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

//Task 2: Digit Sum Loop(String)    

    public static int digitSum(int num) {
        while (num >= 10) {
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

//Task 3: Consecutive Number Summer 

    public static void consecutiveNumberSum(int num) {
        boolean found = false;
        for (int start = 1; start < num; start++) {
            int sum = 0;
            for (int i = start; i < num; i++) {
                sum += i;
                if (sum == num) {
                    found = true;
                    printSequence(start, i);
                    break;
                }
                if (sum > num) {
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("No Consecutive Number Found");
        }
    }
//Task 3: Consecutive Number Summer    

    private static void printSequence(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i == end) {
                System.out.print(i);
            } else {
                System.out.print(i + " + ");
            }
        }
        System.out.println();
    }


//Task 4: Caesar Cipher with Shift Variability

    public static String encryption(String input, int[] shiftPattern) {
        StringBuilder encrypted = new StringBuilder();
        int patternLen = shiftPattern.length;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                int sh = shiftPattern[i % patternLen];
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + sh + 26) % 26 + base);
                encrypted.append(ch);
            } else if (Character.isDigit(ch)) {
                int sh = shiftPattern[i % patternLen];
                ch = (char) ((ch - '0' + sh + 10) % 10 + '0');
                encrypted.append(ch);
            } else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }


//  * Task 5: Encoding Challenge with ASCII Conversion

    public static String encodeHighestDigits(int[] array, int[] series) {
        if (array.length == 0 || series.length == 0) {
            return "";
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        int n = array.length;
        StringBuilder encodedString = new StringBuilder();

        for (int i : series) {
            if (i > 0 && i <= n) {
                int digit = array[n - i];
                encodedString.append((int) digit + 48);
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            choose(); 
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                do{
                    System.out.println(constant.enterString);
                    String output = input.nextLine();
                    System.out.println("Pair Combinations:");
                    pairCombination(output);

                    input.nextLine();
                    System.out.println(constant.promptwagin);
                }while(input.nextLine().equalsIgnoreCase ("yes"));
                    break;

                case 2:
                do{
                    System.out.println(constant.positiveNum);
                    try {
                        int num = input.nextInt();
                        if (num < 0) {
                            System.out.println(constant.invalidInput);
                        } else {
                            int result = digitSum(num);
                            System.out.println("Single digit result: " + result);
                        }
                    } catch (Exception e) {
                        System.out.println(constant.invalidInput);
                        input.next(); 
                    }
                    input.nextLine();
                    System.out.println(constant.promptwagin);
                }while(input.nextLine().equalsIgnoreCase ("yes"));
                    break;

                case 3:
                do{
                    System.out.println(constant.positiveNum);
                    try {
                        int num = input.nextInt();
                        if (num > 0) {
                            System.out.println(
                                    "Possible combinations of consecutive natural numbers that sum up to " + num + ":");
                            consecutiveNumberSum(num);
                        } else {
                            System.out.println(constant.positiveNum);
                        }
                    } catch (Exception e) {
                        System.out.println(constant.invalidInput);
                        input.next(); 
                    }
                    input.nextLine();
                    System.out.println(constant.promptwagin);
                }while(input.nextLine().equalsIgnoreCase ("yes"));
                    break;

                case 4:
                do{
                    try {
                        System.out.print(constant.enterString);
                        String text = input.nextLine();

                        System.out.print(constant.shiftPattern);
                        String[] shiftInput = input.nextLine().trim().split(",");

                        int[] shiftPattern = new int[shiftInput.length];

                        for (int i = 0; i < shiftPattern.length; i++) {
                            shiftPattern[i] = Integer.parseInt(shiftInput[i]);
                        }

                        String encryptedMessage = encryption(text, shiftPattern);
                        System.out.println("Encrypted message: " + encryptedMessage);
                    } catch (NumberFormatException e) {
                        System.out.println(constant.invalidPattern);
                    }
                    input.nextLine();
                    System.out.println(constant.promptwagin);
                }while(input.nextLine().equalsIgnoreCase ("yes"));
                    break;

                case 5:
                do{
                    try {
                        System.out.println(constant.elementArray);
                        String arrayInput = input.nextLine();
                        int[] array = new int[arrayInput.length()];
                        for (int i = 0; i < arrayInput.length(); i++) {
                            array[i] = Character.getNumericValue(arrayInput.charAt(i));
                        }

                        System.out.println(constant.series);
                        String seriesInput = input.nextLine();
                        String[] seriesStrings = seriesInput.split(",");
                        int[] series = new int[seriesStrings.length];
                        for (int i = 0; i < seriesStrings.length; i++) {
                            series[i] = Integer.parseInt(seriesStrings[i]);
                        }

                        System.out.println("Encoded String: " + encodeHighestDigits(array, series));
                    } catch (Exception e) {
                        System.out.println(constant.invalidInput);
                        input.next(); 
                    }
                    input.nextLine();
                    System.out.println(constant.promptwagin);
                }while(input.nextLine().equalsIgnoreCase ("yes"));
                    break;

                case 6:
                    System.out.println(constant.exit);
                    break;

                default:
                    System.out.println(constant.choice);
                    break;
            }
        } while (choice != 6);

        input.close();
    }
}

    
    