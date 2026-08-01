package LeetCode.Strings;

public class LC9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int original = x; // Keep track of original x
        int reversed = 0;

        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit; // Multiply accumulating reversed number by 10
            x /= 10;
        }

        return reversed == original;
    }

    public static void main(String[] args) {
        LC9_PalindromeNumber solver = new LC9_PalindromeNumber();

        System.out.println(solver.isPalindrome(121));  // true
        System.out.println(solver.isPalindrome(-121)); // false
        System.out.println(solver.isPalindrome(10));   // false
    }
}
