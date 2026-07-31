package LeetCode.Strings;

import java.util.Arrays;

public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;

        // Stores the last seen index of each ASCII character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If character was seen inside the current window, move 'left' pointer
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }

            // Update the last seen position of the character
            lastSeen[currentChar] = right;

            // Calculate current window length and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LC3_LongestSubstringWithoutRepeatingCharacters solver =
                new LC3_LongestSubstringWithoutRepeatingCharacters();

        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Output 1: " + solver.lengthOfLongestSubstring(s1));
        // Expected: 3 ("abc")

        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Output 2: " + solver.lengthOfLongestSubstring(s2));
        // Expected: 1 ("b")

        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Output 3: " + solver.lengthOfLongestSubstring(s3));
        // Expected: 3 ("wke")
    }
}