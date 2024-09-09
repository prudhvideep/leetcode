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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int top = 0, bottom = m-1, left = 0, right = n-1;

        int [][] spiral = new int[m][n];

        if(m == 1 && n == 1){
            spiral[0][0] = (head != null) ? head.val : -1;
            return spiral;
        }
        
        for(int [] row : spiral)
            Arrays.fill(row,-1);

        while(top <= bottom && left <= right){

            for(int i = left;i < right;i++){
                if(head == null) break;
                spiral[top][i] = head.val;
                head = head.next;
            }

            for(int i = top;i < bottom;i++){
                if(head == null) break;
                spiral[i][right] = head.val;
                head = head.next;
            }

            for(int i = right; i > left;i--){
                if(head == null) break;
                spiral[bottom][i] = head.val;
                head = head.next;
            }

            for(int i = bottom;i > top;i--){
                if(head == null) break;
                spiral[i][left] = head.val;
                head = head.next;
            }

            top++;bottom--;left++;right--;
        }

        if(head != null){
            spiral[m/2][n/2] = head.val;
        }

        return spiral;
    }
}