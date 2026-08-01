package LeetCode.LinkedList;

public class LC141_LinkedListCycle {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Loop runs as long as fast pointer can safely advance 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            // If fast catches up to slow, a cycle exists!
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached null -> end of list reached -> no cycle
        return false;
    }

    public static void main(String[] args) {
        LC141_LinkedListCycle solver = new LC141_LinkedListCycle();

        // Test Case 1: Create a cycle (3 -> 2 -> 0 -> -4 -> 2 ...)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle created!

        System.out.println("Has Cycle: " + solver.hasCycle(head));
        // Expected: true
    }
}