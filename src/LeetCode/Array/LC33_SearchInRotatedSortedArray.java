package LeetCode.Array;

public class LC33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC33_SearchInRotatedSortedArray solver = new LC33_SearchInRotatedSortedArray();

        // Test Case 1: Target exists in rotated array
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Output: " + solver.search(nums1, 0)); // Expected: 4

        // Test Case 2: Target does not exist
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Output: " + solver.search(nums2, 3)); // Expected: -1
    }
}