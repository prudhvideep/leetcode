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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int l = 0;
        
        while(temp!=null){
            temp = temp.next;
            l++;
        }
        
        if(l == n) {
            head = head.next;
            return head;
        }
        
        l = l-n-1;
        temp = head;
        while(l > 0){
            temp = temp.next;
            l--;
        }
        
        if(temp != null) temp.next = (temp.next != null) ? temp.next.next : null;
        
        return head;
    }
}