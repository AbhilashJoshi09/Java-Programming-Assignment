import java.util.Scanner;

public class PrimeChecker {

    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        // Edge cases
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (number <= 3) {
            return true; // 2 and 3 are prime numbers
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Eliminate multiples of 2 and 3
        }
        
        // Check for factors from 5 to sqrt(number)
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        
        return true; // No factors found, so the number is prime
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Enter a number to check if it is prime:");
        int input = scanner.nextInt();
        
        // Close the scanner
        scanner.close();
        
        // Check if the number is prime and display the result
        if (isPrime(input)) {
            System.out.println(input + " is a prime number.");
        } else {
            System.out.println(input + " is not a prime number.");
        }
    }
}

