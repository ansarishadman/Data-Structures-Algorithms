package LeetCode.Strings;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        // FIX 1: Use .isEmpty() instead of == ""
        if (s.isEmpty() || t.isEmpty() || m < n) return "";

        int[] map = new int[256];
        int count = 0;
        int left = 0, minLength = Integer.MAX_VALUE, right = 0;
        int startIndex = -1;

        // Build frequency map for t
        for (int i = 0; i < n; i++) {
            map[t.charAt(i)]++;
        }

        while (right < m) {
            char ch = s.charAt(right);

            // If character is needed by t, increment matched count
            if (map[ch] > 0) {
                count++;
            }
            map[ch]--;

            // FIX 2: Check count == n (length of t), not m!
            while (count == n) {
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                // FIX 3: Increment character back when removing from left
                char leftChar = s.charAt(left);
                map[leftChar]++;

                // If map count becomes > 0, we just lost a needed character from t
                if (map[leftChar] > 0) {
                    count--;
                }
                left++;
            }

            right++;
        }

        // FIX 4: Use (startIndex + minLength) for substring end index
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        LC76_MinimumWindowSubstring solver = new LC76_MinimumWindowSubstring();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Output: " + solver.minWindow(s, t)); // Expected: "BANC"
    }
}