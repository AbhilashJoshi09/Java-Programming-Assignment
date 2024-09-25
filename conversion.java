import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class conversion {
    static boolean isQuit = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;  // Declare choice here so that it can be updated

        do {
            System.out.println("Choose Task");
            System.out.println("1. Decimal to All");
            System.out.println("2. Binary to All");
            System.out.println("3. Octal to All");
            System.out.println("4. Hexadecimal to All");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();  
                switch (choice) {
                    case 1:
                        decimalToAll.main(args); 
                        scanner.nextLine(); 
                        break;

                    case 2:
                        binaryToAll.main(args); 
                        scanner.nextLine();   // Call binaryToAll class
                        break;

                    case 3:
                        octalToAll.main(args);
                        scanner.nextLine();   // Call octalToAll class
                        break;
                        
                    case 4:
                        hexadecimalToAll.main(args); 
                        scanner.nextLine();  // Call hexadecimalToAll class
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.nextLine(); 
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }

        } while (!isQuit);  
        scanner.close();  
    }
}
