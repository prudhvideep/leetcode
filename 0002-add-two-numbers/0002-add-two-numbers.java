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
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode sumList = null, t3 = null,t = null;
            
        int sum = 0, car = 0,a,b;
        
        while(t1 != null && t2 != null){
            a = t1.val;
            b = t2.val;
            
            sum = (a+b+car)%10;
            car = (a+b+car)/10;
            
            if(sumList == null){
                sumList = new ListNode(sum);
                t3 = sumList;
            }else{
                t3.next = new ListNode(sum);
                t3 = t3.next;
            }
            
            t1 = t1.next;
            t2 = t2.next;
        }
        
        t = (t1 != null) ? t1 : t2;
        
        while(t != null){
            a  = t.val;
            
            sum = (a+car)%10;
            car = (a+car)/10;
            
            if(sumList == null){
                sumList = new ListNode(sum);
                t3 = sumList;
            }else{
                t3.next = new ListNode(sum);
                t3 = t3.next;
            }
            
            t = t.next;
        }
        
        
        if(car != 0){
            t3.next = new ListNode(car);            
            return sumList;
        }
        return sumList;
    }
}