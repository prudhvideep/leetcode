/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode removeElements(ListNode head, int val) {

    if (head == null)
      return head;

    while (head != null && head.val == val) {
      head = head.next;
    }

    if (head == null)
      return head;

    ListNode prev = head, cur = head.next;
    ;

    while (cur != null) {
      if (cur.val == val) {
        prev.next = cur.next;
      } else {
        prev = cur;
      }
      cur = cur.next;
    }

    return head;
  }
}