package LeetCode.Array;

public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;

        while (left < right) {
            int base = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = base * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] > height[right]) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LC11_ContainerWithMostWater solver = new LC11_ContainerWithMostWater();

        // Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test Case 1 Output: " + solver.maxArea(height1)); // Expected: 49

        // Test Case 2
        int[] height2 = {1, 1};
        System.out.println("Test Case 2 Output: " + solver.maxArea(height2)); // Expected: 1
    }
}