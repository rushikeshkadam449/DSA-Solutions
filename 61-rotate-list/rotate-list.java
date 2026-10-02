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
        int n = 1;
        while (last.next != null) {
            last = last.next;
            n++;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }

        int newLast = n - k;
        ListNode newTail = head;
        int count = 1;
        while (newTail != null) {
            if (newLast == count) {
                break;
            }
            count++;
            newTail = newTail.next;
        }

        last.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}