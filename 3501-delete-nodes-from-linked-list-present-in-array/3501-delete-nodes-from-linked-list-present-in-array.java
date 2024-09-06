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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set <Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        while(head != null && set.contains(head.val)){
            head = head.next;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while(cur != null){
            if(set.contains(cur.val)){
                cur = cur.next;
                prev.next = cur;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}