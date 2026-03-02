public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "madam"; // String literal in constant pool

        // Simple conditional logic for verification
        if (word.equals(new StringBuilder(word).reverse().toString())) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}