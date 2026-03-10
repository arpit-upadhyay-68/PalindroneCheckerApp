public class PalindromeUC4 {


    public static void main(String[] args) {

        // Hardcoded string
        String word = "madam";

        // Convert string to character array
        char[] chars = word.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}

