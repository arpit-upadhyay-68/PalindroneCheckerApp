import java.util.*;

/**
 * PalindromeApp: Implements UC12 using the Strategy Pattern.
 * This structure encapsulates algorithms into separate strategies
 * that can be swapped at runtime.
 */
public class PalindromeApp {

    // --- 1. THE STRATEGY INTERFACE ---
    interface PalindromeStrategy {
        boolean isValid(String input);
    }

    // --- 2. CONCRETE STRATEGY: STACK (LIFO) ---
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean isValid(String input) {
            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (char c : clean.toCharArray()) stack.push(c);
            for (char c : clean.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    // --- 3. CONCRETE STRATEGY: DEQUE (Double-Ended) ---
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isValid(String input) {
            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : clean.toCharArray()) deque.addLast(c);

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }
            return true;
        }
    }

    // --- 4. MAIN CONTEXT ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome App ===");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.println("\nSelect Strategy:");
        System.out.println("1. Stack Strategy (Reverses String)");
        System.out.println("2. Deque Strategy (Shrinks from both ends)");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        PalindromeStrategy strategy;

        // Polymorphism: Assigning a concrete implementation to the interface type
        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice. Defaulting to Stack.");
            strategy = new StackStrategy();
        }

        // Execute the strategy
        boolean result = strategy.isValid(input);

        System.out.println("\n--- Execution Details ---");
        System.out.println("Algorithm Used: " + strategy.getClass().getSimpleName());
        System.out.println("Result: " + (result ? "Success! It is a palindrome." : "Not a palindrome."));
        System.out.println("--------------------------");

        scanner.close();
    }
}