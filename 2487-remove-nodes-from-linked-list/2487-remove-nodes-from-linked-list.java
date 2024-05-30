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
    public ListNode removeNodes(ListNode head) {
        if(head.next == null)
            return head;
        
        
        ListNode temp = head;
        
        Stack <Integer> st = new Stack <>();
        
        while(temp != null){
            if(st.isEmpty()){
                st.push(temp.val);
            }else{
                while(!st.isEmpty() && temp.val > st.peek()){
                    st.pop();
                }
                st.push(temp.val);
            }
            
            temp = temp.next;
        }
        
        head = null;
        
        while(!st.isEmpty()){
            int top = st.pop();
            ListNode topNode = new ListNode(top);
            
            topNode.next = head;
            head = topNode;
        }
        
        return head;
    }
}