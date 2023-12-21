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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null)
            return (list1 == null) ? list2: list1;
        
        ListNode mergedHead = null, tempHead = null;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(mergedHead == null){
                    mergedHead = list1;
                    list1 = list1.next;
                    mergedHead.next = null;
                    tempHead = mergedHead;
                }else{
                    tempHead.next = list1;
                    tempHead = tempHead.next;
                    list1 = list1.next;
                    tempHead.next = null;
                }
            }else{
                if(mergedHead == null){
                    mergedHead = list2;
                    list2 = list2.next;
                    mergedHead.next = null;
                    tempHead = mergedHead;
                }else{
                    tempHead.next = list2;
                    tempHead = tempHead.next;
                    list2 = list2.next;
                    tempHead.next = null;
                }
            }
        }
        
        while(list1 != null){
            tempHead.next = list1;
            tempHead = tempHead.next;
            list1 = list1.next;
            tempHead.next = null;
        }
        
        while(list2 != null){
            tempHead.next = list2;
            tempHead = tempHead.next;
            list2 = list2.next;
            tempHead.next = null;
        }
        
        return mergedHead;
    }
}