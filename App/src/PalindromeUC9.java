public class PalindromeUC10 {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start crosses end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for the next inner characters
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        // Hardcoded string
        String word = "121";

        // Check palindrome using recursion
        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}