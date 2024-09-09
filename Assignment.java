import java.util.Scanner;

public class Assignment {
    public static void choose() {
        System.out.println("Choose Task");
        System.out.println("1. Valid Parentheses Combination Generator:");
        System.out.println("2. Digit Sum Loop");
        System.out.println("3. Consecutive Number Summer");
        System.out.println("4. Caesar Cipher with Shift Variability");
        System.out.println("5. Encoding Challenge with ASCII Conversion");
    }

    public static int digitSum(int num) {
        while (num >= 10) {  // Change condition to >= 10
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

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

    public static String encryption(String input, int[] shiftpattern){
        //this function yet to be implemented.
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        choose();
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                // Placeholder for Task 1
                break;

            case 2:
                System.out.println("Enter a positive integer number: ");
                try {
                    int num = input.nextInt();
                    if (num < 0) {
                        System.out.println("Invalid input. Please enter a positive integer.");
                    } else {
                        int result = digitSum(num);
                        System.out.println("Single digit result: " + result);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
                break;

            case 3:
                System.out.println("Enter a positive integer: ");
                try{
                    int num = input.nextInt();
                    if (num > 0) {
                       System.out.println("Possible combinations of consecutive natural numbers that sum up to " + num + ":");
                       consecutiveNumberSum(num);
                    } else {
                      System.out.println("Please enter a positive number.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }    
                break;

            case 4:
                System.out.println("Enter the string to encrypt: "); 
                input = scanner.nextline();
                System.out.print("Enter the shift pattern (comma-separated): ");
                String[] shiftInput = scanner.nextLine().split(",");
                int[] shiftPattern = new int[shiftInput.length];   

            default:
                System.out.println("Invalid choice");
                break;
        }

        input.close();
    }
}
