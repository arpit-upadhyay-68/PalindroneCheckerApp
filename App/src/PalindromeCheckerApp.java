import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeUC6 {

    public static void main(String[] args) {

        // Hardcoded string
        String word = "bob";

        // Create Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and Push characters
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);    // enqueue
            stack.push(ch);   // push
        }

        boolean isPalindrome = true;

        // Compare dequeue (FIFO) vs pop (LIFO)
        while (!queue.isEmpty()) {
            char queueChar = queue.remove(); // dequeue
            char stackChar = stack.pop();    // pop
            if (queueChar != stackChar) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}