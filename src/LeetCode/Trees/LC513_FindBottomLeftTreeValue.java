package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;
public class LC513_FindBottomLeftTreeValue {
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

    // Right-to-Left BFS Approach -> O(N) Time, O(N) Space
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr = root;

        while (!queue.isEmpty()) {
            curr = queue.poll();

            // Push RIGHT child first, then LEFT child
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }

        // The last node popped from the queue is the bottom-leftmost node
        return curr.val;
    }

    public static void main(String[] args) {
        LC513_FindBottomLeftTreeValue solver = new LC513_FindBottomLeftTreeValue();

        // Building Tree:
        //       1
        //      / \
        //     2   3
        //    /   / \
        //   4   5   6
        //      /
        //     7
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6))
        );

        System.out.println("Bottom Left Value (Expected 7): " + solver.findBottomLeftValue(root));
    }
}