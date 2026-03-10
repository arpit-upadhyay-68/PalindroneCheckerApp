import java.util.Scanner;
import java.util.Stack;

/**
 * PalindromeApp: A console-based application to validate palindromes.
 * This implementation fulfills UC11 by encapsulating logic in a Service class.
 */
public class PalindromeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service (Encapsulation)
        PalindromeService service = new PalindromeService();

        System.out.println("=== Palindrome Checker (OOPS Edition) ===");
        System.out.print("Enter text to verify: ");

        String input = scanner.nextLine();

        // Execution via the Service method
        if (service.checkPalindrome(input)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        System.out.println("=========================================");
        scanner.close();
    }

    /**
     * Internal Service Class (UC11)
     * Responsibility: Pure logic and data structure management.
     */
    static class PalindromeService {

        /**
         * Uses a Stack (LIFO) to reverse and compare the string.
         * Concept: If the original and reversed versions are equal, it's a palindrome.
         */
        public boolean checkPalindrome(String input) {
            if (input == null || input.trim().isEmpty()) {
                return false;
            }

            // Data Cleaning: Remove non-alphanumeric and ignore case
            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // Internal Data Structure: Stack
            Stack<Character> stack = new Stack<>();

            // Step 1: Push all characters onto the stack
            for (char c : clean.toCharArray()) {
                stack.push(c);
            }

            // Step 2: Pop and compare (Stack pops in reverse order)
            for (char c : clean.toCharArray()) {
                if (c != stack.pop()) {
                    return false; // Mismatch found
                }
            }

            return true; // All characters matched
        }
    }
}