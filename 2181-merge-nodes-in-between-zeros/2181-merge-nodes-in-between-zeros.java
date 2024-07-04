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
    public ListNode mergeNodes(ListNode head) {
        ListNode ret = null;
        
        ListNode temp = null;
        
        ListNode mainTrav = head.next;
        int sum = 0;
        
        while(mainTrav != null){
           if(mainTrav.val != 0){
               sum += mainTrav.val;
           }else{
              if(temp == null){
                  ret = new ListNode(sum);
                  temp = ret;
              }else{
                  temp.next = new ListNode(sum);
                  temp = temp.next;
              }
              sum = 0;
           }
            
            mainTrav = mainTrav.next;
        }
        
        return ret;
    }
}