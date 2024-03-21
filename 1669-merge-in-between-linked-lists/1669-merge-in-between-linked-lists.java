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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1, temp1 = list2, start = null, end = null;
        
        int count = 0;
        start = temp;
        
        while(temp.next != null){
            if(count == (a-1))
                start = temp;
            
            if(count == b)
                end = temp;
            
            temp = temp.next;
            count++;
        }
            
        start.next = list2;
        
        while(temp1.next != null)
            temp1 = temp1.next;
        
        if(end != null && end.next != null)
            temp1.next = end.next;
            
        
        return list1;
    }
}