package LeetCode.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LC19_RemoveNthNodeFromEndOfList {

        // Definition for singly-linked list node
        public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        // 1-Pass Optimal Solution
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode fast = dummy;
            ListNode slow = dummy;

            // 1. Advance fast pointer (n + 1) steps to create a gap of n nodes
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            // 2. Move both pointers together until fast reaches the end
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 3. Skip the N-th node from the end
            slow.next = slow.next.next;

            return dummy.next;
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
            LC19_RemoveNthNodeFromEndOfList solver = new LC19_RemoveNthNodeFromEndOfList();

            // Test Case 1: 1 -> 2 -> 3 -> 4 -> 5, n = 2
            ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            System.out.print("Test 1 (Remove 2nd from end): ");
            ListNode res1 = solver.removeNthFromEnd(head1, 2);
            printList(res1);
            // Expected Output: 1 -> 2 -> 3 -> 5

            // Test Case 2: 1, n = 1 (Removing the only node)
            ListNode head2 = new ListNode(1);
            System.out.print("Test 2 (Remove only node): ");
            ListNode res2 = solver.removeNthFromEnd(head2, 1);
            printList(res2);
            // Expected Output: (empty/null)

            // Test Case 3: 1 -> 2, n = 2 (Removing the head node)
            ListNode head3 = new ListNode(1, new ListNode(2));
            System.out.print("Test 3 (Remove head node): ");
            ListNode res3 = solver.removeNthFromEnd(head3, 2);
            printList(res3);
            // Expected Output: 2
        }
    }