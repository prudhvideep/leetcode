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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode temp = head;
        Set <Integer> s = new HashSet<>();
        
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
                s.add(temp.val);
            }else{
                temp = temp.next;
            }
        }
        
        while(head != null && s.contains(head.val)){
            head = head.next;
        }
        temp = head;
        while(temp != null && temp.next != null){
            if(s.contains(temp.next.val)){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        
        return head;
        
        
    }
}