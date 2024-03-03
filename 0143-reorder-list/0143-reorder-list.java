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
    public void reorderList(ListNode head) {
        int l = 0;
        ListNode temp = head;
        Stack<ListNode> s = new Stack<>();
        
        while(temp != null){
            temp = temp.next;
            l++;
        }
        
        if(l <= 2)
            return;
        
        temp = head;
        
        l = ((l+1)/2)-1;
        
        for(int i = 0;i < l;i++){
            temp =temp.next;
        }
        
        ListNode node = temp.next;
        temp.next = null;
        
        while(node != null){
            s.push(node);
            node = node.next;
        }
        
        node = head;
        
        while(!s.isEmpty()){
            ListNode temp1 = s.peek(), temp2 = null;
            temp1.next = null;
            s.pop();
            
            temp2 = node.next;
            node.next = temp1;
            node = node.next;
            node.next = temp2;
            node = node.next;
        }
        
    }
}