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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null, head2 = null;

        if(head == null || head.next == null)
            return head;

        ListNode temp = head, temp1 = null, temp2 = null;

        while(temp != null){
            if(temp.val < x){
                if(head1 == null){
                    head1 = new ListNode(temp.val);
                    temp1 = head1;                    
                }else{
                    temp1.next = new ListNode(temp.val);
                    temp1 = temp1.next;
                }
            }else{
                if(head2 == null){
                    head2 = new ListNode(temp.val);
                    temp2 = head2;                    
                }else{
                    temp2.next = new ListNode(temp.val);
                    temp2 = temp2.next;
                }
            }
            temp = temp.next;
        }

        if(temp1 != null){
            temp1.next = head2;
            return head1;
        }
        return head2;
    }
}