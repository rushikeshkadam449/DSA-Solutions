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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode last = head;
        int count = 1;
        while (last.next != null) {
            last = last.next;
            count++;
        }
        k = k % count;
        last.next = head;

        int newLast = count - k;
        ListNode newTail = head;
        while (newLast > 1) {
            newTail = newTail.next;
            newLast--;
        }
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}