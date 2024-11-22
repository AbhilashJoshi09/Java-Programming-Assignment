/***Write a Java program to print the nth number in the Fibonacci series without using loops.
 * 1.Fibonacci Sequence: The sequence starts with 0 and 1, and each subsequent number is the sum of the previous two. For example, the sequence begins as follows: 0, 1, 1, 2, 3, 5, 8, 13, 21, etc.
 2.Recursion: The method fibonacci is defined recursively, meaning it calls itself to compute the Fibonacci number for the given index.
 3.Input Handling: The program uses the Scanner class to read user input and includes error handling to manage invalid inputs.

 The code is structured into two main parts:

The fibonacci method, which computes the Fibonacci number.
The main method, which handles user input and output.

Owner: Abhilash Joshi;
Date : 11-9-24;
 */


import java.util.Scanner;

public class nthFibonacci {

    public static int fibonacci(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index value: ");
        
        String input = scanner.nextLine();
        
        try {
            long n = Long.parseLong(input);
            if (n < 0) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
            } else {
                System.out.println("Fibonacci number at index " + n + " is: " + fibonacci(n));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
