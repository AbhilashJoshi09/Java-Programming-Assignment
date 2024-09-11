/***Write a Java program that takes a string as input and finds the number of consonants in
the string.
1.Consonants: In the English alphabet, consonants are all letters except for the vowels (A, E, I, O, U). This program focuses on identifying these consonants.
2.Recursion: This is a programming technique where a method calls itself to solve a problem. In this case, the method consonantCount calls itself to iterate through the string.
3.Character Manipulation: The program uses methods from the Character class to convert characters to lowercase and to check their range.

A static variable consonantCount to keep track of the number of consonants.
A recursive method consonantCount(String input, int index) that processes each character of the string.
A main method that handles user input and initiates the counting process.

Owner : Abhilash Joshi;
Date : 11-9-24;
 */

import java.util.Scanner;

public class countConsonant {
    static int consonantCount = 0;
    public static void consonantCount(String input, int index){
        if(index == input.length()){
            return;
        }

        char character = Character.toLowerCase(input.charAt(index));
        if (character >= 'A' && character <= 'Z' && !(character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U')) {
            consonantCount++;
        }
        consonantCount(input, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = scanner.nextLine();
        consonantCount(input,0);

        System.out.println("consonent:" + consonantCount);
    }

   
   
}
