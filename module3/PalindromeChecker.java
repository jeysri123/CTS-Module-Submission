import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanedInput).reverse().toString();
        
        boolean isPalindrome = cleanedInput.equals(reversed);
        
        System.out.println("Is palindrome: " + isPalindrome);
        
        scanner.close();
    }
} 