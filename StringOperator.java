/***The available operations are
listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its
respective operation based on the user's input.

1.appendString(String currentString, String newString)
Description: Appends the newString to the currentString and returns the updated string. 
The currentString is modified to include the newString.

2.countWords(String input)
Description: Counts the total number of words in the given input string.
 Words are defined as sequences of letters or digits separated by spaces.

3.palindrome(String input)
Description: Checks if the given input string is a palindrome by reversing the string and comparing it to the original. 
Returns the reversed string. 

4.reverse(String input)
Description: Reverses the given input string and returns the reversed string.

5.sort(String input)
Description: Sorts the characters of the input string in alphabetical order and returns the sorted string.

6.maxRepeat(String input)
Description: Finds and returns the character that appears the most frequently in the given input string. 
If multiple characters have the same maximum frequency, it returns the first one encountered.

7.shift(String input, int n)
Description: Moves the first n characters of the input string to the end of the string.
 Returns the resulting string after the shift operation.

 8.splice(String input, int startlength, int endlength)
Description: Removes a substring from the input string, starting at the index startlength and with length endlength.
 Returns the string with the specified substring removed.

 9.plitString(String input)
Description: Splits the given input string into an array of words based on spaces. Returns the array of words.

10.replace(String p, char a, char b)
Description: Replaces all occurrences of the character a with the character b in the given p string.
 Returns the updated string with the replacements.
Owner: AbhilashJoshi
Date: 5/9/24
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

/***Appends 
 */

 public static String appendString(String CurrentStr, String GetString) {
    if (CurrentStr == null) {
        CurrentStr = "";
    }
    if (GetString == null) {
        GetString = "";
    }
    return CurrentStr + " " + GetString;
}



/***Counts the total number of words in the current string.
 */    

    public static int countWords(String input){
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


/***Checks if the current string is a palindrome. 
 */  

 
    public static String palindrome(String input) {
        char[] reverseString = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reverseString[i] = input.charAt(input.length() - 1 - i);
        }
        return new String(reverseString); // Return the reversed string
    }

/***Description: Reverses the current string.
 */

    public static String reverse(String input) {
        char[] reverseString = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            reverseString[i] = input.charAt(input.length() - 1 - i);
        }
        return new String(reverseString);
    }

/***Sorts the characters of the current string in alphabetical order. */    

    public static String sort(String input){
        char[] abc = input.toCharArray();
        for(int i = 0; i < abc.length; i++){
            for(int j = i + 1; j < abc.length; j++){
                if(abc[i] > abc[j]){
                    char temp = abc[i];
                    abc[i] = abc[j];
                    abc[j] = temp;
                }
            }
        }
        return new String(abc);
    } 


/*** Finds and returns the character that appears the most frequently in the
current string.*/    
    public static char maxRepeat(String input) {
        int[] charCount = new int[256];
        for (int i = 0; i < input.length(); i++){
            charCount[input.charAt(i)]++;
        }
        int maxCount = 0;
        char result = '\0';
        for (int i = 0; i < charCount.length; i++){
            if (charCount[i] > maxCount){
                maxCount = charCount[i];
                result = (char) i;
            }
        }
        return result;  
    }


/***Moves the first n characters from the start to the end of the current string. */    

    public static String shift(String input, int n) {
        int length = input.length();
        n = (n % length + length) % length;
        return input.substring(length - n) + input.substring(0,length - n);        
    }


/***Description: Removes a substring from the current string starting at index start and of
length length. */    

    public static String splice(String input, int startlength, int endlength) {
        char[] result = new char[input.length() - endlength];
        int index = 0;

        for(int i = 0; i < startlength; i++){
            result[index] = input.charAt(i);
            index++;
        }

        for(int i = startlength + endlength; i < input.length(); i++){
            result[index] = input.charAt(i);
            index++;
        }

        String fString = "";
        for(int i = 0; i < result.length; i++){
            fString += result[i];
        }
        return fString;
    }


/***Splits the current string into an array of words. */    
    public static String[] splitString(String input) {
        int wordCount = 1;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' ' ){
                wordCount++;
            } 
        }
        
        String[] words = new String[wordCount];
        int wordIndex = 0;
        String  correntWord = "";

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if(c == ' '){
                words[wordIndex] = correntWord;
                wordIndex++;
                correntWord = " ";
            }else{
                correntWord += c;
            }
        }

        words[wordIndex] = correntWord;
        return words;
    }


/***Replaces all occurrences of character a with character b in the current
string. */    

    public static String replace(String p,  char a, char b) {
        String newString = ""; 
        
        for (int i = 0; i < p.length(); i++) {
            
            if (p.charAt(i) == a) {
                newString += b;
            } else {
                newString += p.charAt(i);
            }
        }
        return newString;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = ""; // Initialize input variable
        do {
            Choose();
            int choice;
            try {
                choice = scanner.nextInt();  
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.close();
                return; 
            }
            
            switch (choice) {
                case 1:
                do {
                    System.out.println("Enter the initial string: ");
                    currentString = scanner.nextLine();
        
                    do {
                        System.out.println("Enter the string to append: ");
                        String GetString = scanner.nextLine();
                        currentString = appendString(currentString, GetString);
                        System.out.println("Updated String: " + currentString);
                        System.out.println("Do you want to append more? (Yes/No): ");
                    } while (scanner.nextLine().equalsIgnoreCase("Yes"));
                    
                    System.out.println("Do you want to append again with a new string? (Yes/No): ");
                } while (scanner.nextLine().equalsIgnoreCase("Yes"));
                break;
        
        
                case 2:
                    System.out.println("Enter line of text (type 'NO' in new line to exit):");
                    while (true) {
                        input = scanner.nextLine();
                        if (input.equalsIgnoreCase("NO")) {
                            break;
                        }
                        int wordcount = countWords(input);
                        System.out.println("Number of words: " + wordcount);
                    }
                    break;
    
                case 3:
                    do {
                        System.out.println("Enter String text: ");
                        String newrep = scanner.nextLine();
                        
                        System.out.println("Current String: " + newrep);
    
                        System.out.println("Enter char to replace: ");
                        char charToReplace = scanner.next().charAt(0);
    
                        System.out.println("Enter replacement character: ");
                        char replacementChar = scanner.next().charAt(0);
                        
                        String rep = replace(newrep, charToReplace, replacementChar);
                        System.out.println(rep);
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        scanner.nextLine(); // Consume newline left-over
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;    
    
                case 4:
                    do {
                        System.out.println("Enter any Word :");
                        input = scanner.nextLine();  
                        if (input.equalsIgnoreCase("No")) {
                            break;
                        }
    
                        String reversed = palindrome(input); // Use the Palindrome method
                        if (input.equalsIgnoreCase(reversed)) {
                            System.out.println("String is a Palindrome");
                        } else {
                            System.out.println("String is not a Palindrome");
                        }
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));            
                    break;
    
                case 5:
                    do {
                        System.out.println("Enter a String to Splice: ");
                        input = scanner.nextLine();
    
                        System.out.println("Enter the starting index: ");
                        int startlength = scanner.nextInt();
    
                        System.out.println("Enter the length of substring to remove: ");
                        int endlength = scanner.nextInt();
    
                        String result = splice(input, startlength, endlength);
    
                        System.out.println("Result: " + result);
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        scanner.nextLine(); // Consume newline left-over
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;
    
                case 6:
                    do {
                        System.out.println("Enter a line to split: ");
                        input = scanner.nextLine();
                        String[] output = splitString(input);
    
                        System.out.println("Words in String: ");
                        for (String word : output) {
                            System.out.println(word);
                        }
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));    
                    break;
            
                case 7:
                    do {
                        System.out.println("Enter a string to find its max repeating character: ");
                        input = scanner.nextLine();
                        System.out.println("Max Repeating Character: " + maxRepeat(input)); 
                        
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;
               
                case 8:
                    do {
                        System.out.println("Enter String to Sort: "); 
                        input = scanner.nextLine();
                        String sortedString = sort(input);
                        System.out.println("Sorted String is: " + sortedString); 
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;  
    
                case 9:
                    do {
                        System.out.println("Enter a string to Shift");    
                        input = scanner.nextLine();
                        System.out.println("Enter number of positions to shift:");
                        int n = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        System.out.println("Result: " + shift(input, n));
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;
    
                case 10:
                    do {
                        System.out.println("Enter A String to Reverse:");
                        input = scanner.nextLine();
                        String reversedString = reverse(input);
                        System.out.println("Reversed String is: " + reversedString);
    
                        System.out.println("Enter 'yes' to continue and 'no' to exit");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("yes"));
                    break;     
    
                default:
                    System.out.println("Invalid choice");
                break;
            }

            System.out.println("Do you want to perform another operation? Enter 'yes' to continue or 'no' to exit.");
            input = scanner.nextLine();

        } while (input.equalsIgnoreCase("yes"));
    
        scanner.close();
    }
    
}    