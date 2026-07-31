package LeetCode.Strings;

public class LC424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;

            // Track the highest frequency of any single character in the current window
            maxFreq = Math.max(maxFreq, count[currentChar - 'A']);

            // Current window size is (right - left + 1).
            // If characters to replace > k, shrink window from left.
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update max valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LC424_LongestRepeatingCharacterReplacement solver =
                new LC424_LongestRepeatingCharacterReplacement();

        // Test Case 1
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Output 1: " + solver.characterReplacement(s1, k1));
        // Expected: 4 ("AAAA" or "BBBB")

        // Test Case 2
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Output 2: " + solver.characterReplacement(s2, k2));
        // Expected: 4 ("AABBBBA" -> "AABBBBA" taking "ABBB" or "BBBA")
    }
}