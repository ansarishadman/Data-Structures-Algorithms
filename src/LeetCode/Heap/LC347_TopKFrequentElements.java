package LeetCode.Heap;

import java.util.*;
public class LC347_TopKFrequentElements {

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int n : nums) {
                counter.put(n, counter.getOrDefault(n, 0) + 1);
            }

            // Max-Heap sorted by frequency descending
            PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b.getValue(), a.getValue())
            );

            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                heap.offer(entry);
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = Objects.requireNonNull(heap.poll()).getKey();
            }

            return res;
        }
    }

    // Runner method inside IntelliJ
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test 1 Result: " + Arrays.toString(solver.topKFrequent(nums1, k1)));
        // Output: [1, 2]

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test 2 Result: " + Arrays.toString(solver.topKFrequent(nums2, k2)));
        // Output: [1]
    }
}