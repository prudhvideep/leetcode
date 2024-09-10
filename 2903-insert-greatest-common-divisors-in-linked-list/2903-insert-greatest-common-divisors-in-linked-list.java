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
    public int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode prev = head, cur = head.next;

        while(cur != null){
            int a = prev.val;
            int b = cur.val;

            ListNode newNode = new ListNode(gcd(a,b));
            prev.next = newNode;
            newNode.next = cur;
            prev = cur;
            cur = cur.next;

        }

        return head;
    }
}