/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first = head, second = head;
        boolean fromStart = false;

        if (left == 1)
            fromStart = true;

        if (head.next == null)
            return head;

        if (left == right)
            return head;

        while ((left)-- > 2) {
            first = first.next;
        }

        while ((right)-- > 1) {
            second = second.next;
        }

        ListNode temp = second.next;
        second.next = null;
        second = temp;

        ListNode start = null;
        if (!fromStart) {
            start = first.next;
            first.next = null;
        }else{
            start = first;
        }

        // reverse

        ListNode prev = null;
        ListNode cur = start;
        ListNode next = start.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;

        if (!fromStart) {
            first.next = cur;
            start.next = second;
        }else{
            head = cur;
            first.next = second;
        }

        return head;

    }
}