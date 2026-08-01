package LeetCode.LinkedList;

public class LC206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = null; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save next node
            curr.next = prev;              // 2. Reverse current node's pointer
            prev = curr;                   // 3. Move prev one step forward
            curr = nextTemp;               // 4. Move curr one step forward
        }

        return prev; // prev is the new head of the reversed list
    }

    public static void main(String[] args) {
        // Helper to construct: 1 -> 2 -> 3 -> 4 -> 5
        LC206_ReverseLinkedList solver = new LC206_ReverseLinkedList();

        // 1. Build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 2. Reverse the list and store the NEW head
        ListNode reversedHead = solver.reverseList(head);

        // 3. Loop through all nodes to print
        System.out.print("Output: ");
        ListNode curr = reversedHead;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

}
