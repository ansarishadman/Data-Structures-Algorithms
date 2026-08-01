package LeetCode.LinkedList;

public class LC143_ReorderList {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Split the list into two halves

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Merge the two halves (head and prev) alternately
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("Output: ");
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC143_ReorderList solver = new LC143_ReorderList();

        // Test Case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solver.reorderList(head1);
        printList(head1);
        // Expected Output: 1 -> 5 -> 2 -> 4 -> 3

        // Test Case 2: 1 -> 2 -> 3 -> 4
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solver.reorderList(head2);
        printList(head2);
        // Expected Output: 1 -> 4 -> 2 -> 3
    }
}