package LeetCode.Array;

public class LC209_MinimumSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        // Expand the right boundary of the window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink window from the left while current sum is >= target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // Return 0 if no valid subarray was found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);
        System.out.println("Smallest Subarray Length: " + result); // Output: 2 ([4, 3])
    }
}