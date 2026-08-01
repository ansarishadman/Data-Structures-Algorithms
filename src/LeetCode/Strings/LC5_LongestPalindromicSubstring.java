package LeetCode.Strings;

public class LC5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around single character (Odd length)
            int len1 = expandAroundCenter(s, i, i);

            // Expand around two characters (Even length)
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // Update bounds if we find a strictly longer palindrome
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // Move left pointer leftward
            right++; // Move right pointer rightward
        }
        // When loop stops, left and right have gone 1 step too far.
        // Valid palindrome length = (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        LC5_LongestPalindromicSubstring solver = new LC5_LongestPalindromicSubstring();

        // Test Case 1
        String s1 = "babad";
        System.out.println("Input: " + s1 + " -> Output: " + solver.longestPalindrome(s1));
        // Expected: "bab" or "aba"

        // Test Case 2
        String s2 = "cbbd";
        System.out.println("Input: " + s2 + " -> Output: " + solver.longestPalindrome(s2));
        // Expected: "bb"
    }
}