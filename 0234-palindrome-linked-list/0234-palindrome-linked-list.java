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
    public boolean isPaliUtil(ArrayList <Integer> al){
        int l = 0, h = al.size()-1;
        
        while(l <= h){
            if(al.get(l) != al.get(h)){
                return false;
            }
            l++;h--;
        }
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        ArrayList <Integer> al = new ArrayList<>();
        
        ListNode temp = head;
        
        int len = 0;
        
        while(temp!= null){
            al.add(temp.val);
            temp = temp.next;
        }
        
        return isPaliUtil(al);
    }
}