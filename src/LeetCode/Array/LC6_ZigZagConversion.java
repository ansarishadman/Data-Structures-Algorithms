package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;
public class LC6_ZigZagConversion {

    public String convert(String s, int numRows) {
        // Base Guard Check: Prevents IndexOutOfBoundsException
        if (s == null || numRows <= 0) {
            return "";
        }
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character and append to current row
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);

            // Change direction when reaching top (0) or bottom (numRows - 1)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move pointer up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all row buffers into the final output
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LC6_ZigZagConversion solution = new LC6_ZigZagConversion();

        // Test Case 1: Standard Example (numRows = 3)
        String s1 = "ASIMISAGOODBOY";
        int rows1 = 3;
        String ans1 = solution.convert(s1, rows1);
        System.out.println("Test 1 Result: " + ans1);
        System.out.println("Expected:      AIOOSMSGOBYIAD\n");

        // Test Case 3: Single Row Edge Case (numRows = 1)
        String s2 = "AB";
        int rows2 = 1;
        String ans2 = solution.convert(s2, rows2);
        System.out.println("Test 2 Result: " + ans2);
        System.out.println("Expected:      AB\n");

        // Test Case 4: Single Character Edge Case
        String s3 = "A";
        int rows3 = 1;
        String ans3 = solution.convert(s3, rows3);
        System.out.println("Test 3 Result: " + ans3);
        System.out.println("Expected:      A\n");
    }
}