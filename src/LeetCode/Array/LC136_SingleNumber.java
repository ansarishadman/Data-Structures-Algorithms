package LeetCode.Array;

public class LC136_SingleNumber {
    public static int findSingleElement(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num; // Accumulate XOR across all elements
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single Element: " + findSingleElement(nums)); // Output: 4
    }
}