package LeetCode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LC57_InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add all intervals that come strictly BEFORE newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge all OVERLAPPING intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged newInterval
        result.add(newInterval);

        // Phase 3: Add all remaining intervals that come AFTER newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> back to 2D array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        LC57_InsertIntervals solver = new LC57_InsertIntervals();

        // Test Case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Output 1: " + Arrays.deepToString(solver.insert(intervals1, newInterval1)));
        // Expected: [[1, 5], [6, 9]]

        // Test Case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Output 2: " + Arrays.deepToString(solver.insert(intervals2, newInterval2)));
        // Expected: [[1, 2], [3, 10], [12, 16]]
    }
}