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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)
            return head;

        ListNode prev,cur,next;
        
        cur = head;
        next = null;
        prev = null;
        
        while(cur != null && cur.next != null){
            next = cur.next;
            
            cur.next = next.next;
            next.next = cur;
            if(prev == null){
                prev = next;
                head = prev;
            }else{
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
            
            
        }
        
        return head;
    }
}