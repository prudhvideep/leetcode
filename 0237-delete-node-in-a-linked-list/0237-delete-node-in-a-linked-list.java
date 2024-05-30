/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node, next = node.next;
        
        while(next.next != null){
            int temp = cur.val;
            cur.val = next.val;
            next.val = temp;
            
            cur = next;
            next = next.next;
        }
        
        cur.val = next.val;
        cur.next = null;
    }
}