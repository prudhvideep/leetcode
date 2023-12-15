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
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        
        ListNode temp = head;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        if(len == 1)
            return null;
        
        temp = head;
        len = len/2-1;
        
        while(len > 0){
            temp = temp.next;
            len--;
        }
        temp.next = temp.next.next;
        
        return head;
    }
}