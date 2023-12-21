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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode cur = head, nex = head.next, pre = null;
        while(cur != null){
            cur.next = pre;
            pre = cur;
            cur = nex;
            if(nex != null)
                nex = nex.next;
        }
        
        return pre;
    }
}