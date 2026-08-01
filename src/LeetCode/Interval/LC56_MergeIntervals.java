package LeetCode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LC56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. Sort intervals by start time O(N log N)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // If result is empty OR current interval doesn't overlap with the last added one
            if (result.isEmpty() || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                // Overlap exists -> Merge by extending the end boundary
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        LC56_MergeIntervals solver = new LC56_MergeIntervals();

        // Test Case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Output 1: " + Arrays.deepToString(solver.merge(intervals1)));
        // Expected: [[1, 6], [8, 10], [15, 18]]

        // Test Case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Output 2: " + Arrays.deepToString(solver.merge(intervals2)));
        // Expected: [[1, 5]]
    }
}