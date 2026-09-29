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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }
        ListNode before = null;
        ListNode start = head;
        int pos = 1;

        while (start != null) {

            if (pos < left) {
                before = start;
                start = start.next;
                pos++;
                continue;
            }

            int times = right - left + 1;
            ListNode curr = start;
            ListNode prev = null;

            while (times > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

                times--;
            }

            start.next = curr;
            if (before == null) {
                return prev;
            }
            before.next = prev;
            return head;
        }
        return head;

    }
}