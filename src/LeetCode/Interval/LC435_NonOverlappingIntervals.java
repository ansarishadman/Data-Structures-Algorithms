package LeetCode.Interval;

import java.util.Arrays;
public class LC435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by END time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++; // Overlap -> remove current interval
            } else {
                prevEnd = intervals[i][1]; // No overlap -> update end marker
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC435_NonOverlappingIntervals solver = new LC435_NonOverlappingIntervals();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Output 1: " + solver.eraseOverlapIntervals(intervals1)); // Expected: 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Output 2: " + solver.eraseOverlapIntervals(intervals2)); // Expected: 2
    }
}