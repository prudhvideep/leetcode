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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode sumList = null, temp3 = null;
            
        int sum = 0, car = 0;
        
        while(temp1 != null && temp2 != null){
            int a = temp1.val;
            int b = temp2.val;
            
            sum = (a+b+car)%10;
            car = (a+b+car)/10;
            
            if(sumList == null){
                sumList = new ListNode(sum);
                temp3 = sumList;
            }else{
                temp3.next = new ListNode(sum);
                temp3 = temp3.next;
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        while(temp1 != null){
            int a  = temp1.val;
            
            sum = (a+car)%10;
            car = (a+car)/10;
            
            if(sumList == null){
                sumList = new ListNode(sum);
                temp3 = sumList;
            }else{
                temp3.next = new ListNode(sum);
                temp3 = temp3.next;
            }
            
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            int b  = temp2.val;
            
            sum = (b+car)%10;
            car = (b+car)/10;
            
            if(sumList == null){
                sumList = new ListNode(sum);
                temp3 = sumList;
            }else{
                temp3.next = new ListNode(sum);
                temp3 = temp3.next;
            }
            
            temp2 = temp2.next;
        }
        
        if(car != 0){
            temp3.next = new ListNode(car);            
            return sumList;
        }
        return sumList;
    }
}