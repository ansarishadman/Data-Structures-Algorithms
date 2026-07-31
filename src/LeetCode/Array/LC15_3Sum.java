package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LC15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;

            if (i > 0 && nums[i] == nums[i-1]) continue;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>
                            (Arrays.asList(nums[i], nums[j], nums[k]));
                    set.add(list);
                    j++;
                    k--;

                    if(j < k && nums[j] == nums[j-1]) continue;
                    if(j < k && nums[k] == nums[k+1]) continue;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        LC15_3Sum solver = new LC15_3Sum();

        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Output 1: " + solver.threeSum(nums1));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Output 2: " + solver.threeSum(nums2));
        // Expected: []
    }
}
