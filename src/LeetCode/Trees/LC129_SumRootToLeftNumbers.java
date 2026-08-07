package LeetCode.Trees;

public class LC129_SumRootToLeftNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Build the number for the current path
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the accumulated path number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Return the sum of numbers formed by left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    public static void main(String[] args) {
        LC129_SumRootToLeftNumbers solver = new LC129_SumRootToLeftNumbers();

        // Example: Tree 1 -> 2, 1 -> 3
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Total Sum (Expected 25): " + solver.sumNumbers(root));
    }
}