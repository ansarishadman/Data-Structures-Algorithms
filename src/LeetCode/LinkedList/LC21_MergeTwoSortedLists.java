package LeetCode.LinkedList;

public class LC21_MergeTwoSortedLists {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy head acts as anchor for the merged list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Traverse both lists until one is exhausted
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // Attach whichever list has remaining elements
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next; // Real head of merged list
    }

    public static void main(String[] args) {
        LC21_MergeTwoSortedLists solver = new LC21_MergeTwoSortedLists();

        // Construct list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Construct list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = solver.mergeTwoLists(list1, list2);

        // Print merged list
        System.out.print("Output: ");
        while (merged != null) {
            System.out.print(merged.val + (merged.next != null ? " -> " : ""));
            merged = merged.next;
        }
        System.out.println();
        // Expected Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}