import java.util.*;

/**
 * PalindromeApp: UC13 - Performance Comparison
 * Measures and compares execution time across different algorithms.
 */
public class PalindromeApp {

    // --- STRATEGY INTERFACE ---
    interface PalindromeStrategy {
        boolean isValid(String input);
    }

    // --- STACK STRATEGY (O(n) Space, O(n) Time) ---
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

    // --- DEQUE STRATEGY (O(n) Space, O(n) Time - usually faster exit) ---
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isValid(String input) {
            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : clean.toCharArray()) deque.addLast(c);
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Performance Monitor ===");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        // Prepare strategies
        PalindromeStrategy stackStr = new StackStrategy();
        PalindromeStrategy dequeStr = new DequeStrategy();

        System.out.println("\nRunning Benchmark...");
        System.out.println("-------------------------------------------------");

        // 1. Measure Stack Performance
        long startTimeStack = System.nanoTime();
        boolean resStack = stackStr.isValid(input);
        long endTimeStack = System.nanoTime();
        long durationStack = endTimeStack - startTimeStack;

        // 2. Measure Deque Performance
        long startTimeDeque = System.nanoTime();
        boolean resDeque = dequeStr.isValid(input);
        long endTimeDeque = System.nanoTime();
        long durationDeque = endTimeDeque - startTimeDeque;

        // DISPLAY RESULTS
        System.out.printf("%-20s | %-15s | %-10s%n", "Algorithm", "Time (ns)", "Result");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s | %-15d | %-10s%n", "Stack (LIFO)", durationStack, resStack);
        System.out.printf("%-20s | %-15d | %-10s%n", "Deque (Double-End)", durationDeque, resDeque);
        System.out.println("-------------------------------------------------");

        // Simple Analysis
        if (durationStack < durationDeque) {
            System.out.println("Winner: Stack Strategy is faster for this input.");
        } else {
            System.out.println("Winner: Deque Strategy is faster for this input.");
        }

        scanner.close();
    }
}