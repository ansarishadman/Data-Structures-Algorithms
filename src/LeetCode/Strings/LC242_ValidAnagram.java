package LeetCode.Strings;

public class LC242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] map = new int[26];

        // 1. Count frequencies of string s
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        // 2. Decrement frequencies using string t and return false early if count drops below 0
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC242_ValidAnagram solver = new LC242_ValidAnagram();

        // Test Case 1
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Test 1: " + solver.isAnagram(s1, t1)); // Expected: true

        // Test Case 2
        String s2 = "rat", t2 = "car";
        System.out.println("Test 2: " + solver.isAnagram(s2, t2)); // Expected: false
    }
}