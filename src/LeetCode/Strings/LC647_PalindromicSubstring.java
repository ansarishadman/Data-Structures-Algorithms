package LeetCode.Strings;

public class LC647_PalindromicSubstring {

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Count odd-length palindromes (center at single character)
            int countOdd = moveOutward(s, i, i);

            // Count even-length palindromes (center between two characters)
            int countEven = moveOutward(s, i, i + 1);

            // Accumulate counts from both center types
            count += countOdd + countEven;
        }

        return count;
    }

    private int moveOutward(String s, int left, int right) {
        int count = 0;
        // Expand outward as long as bounds are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++; // Each valid expansion is 1 new palindrome!
        }
        return count;
    }

    public static void main(String[] args) {
        LC647_PalindromicSubstring solver = new LC647_PalindromicSubstring();

        // Test Case 1
        System.out.println("Output 1: " + solver.countSubstrings("abc")); // Expected: 3 ("a", "b", "c")

        // Test Case 2
        System.out.println("Output 2: " + solver.countSubstrings("aaa")); // Expected: 6 ("a", "a", "a", "aa", "aa", "aaa")
    }
}