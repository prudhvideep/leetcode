/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        int [] count = {0};
        int [] se = {-1};
        
        inOrder(root,k,count,se);
        return se[0];
    }
    
    void inOrder(TreeNode root, int k, int [] count, int [] se){
        if(root == null || count[0] == k)
            return;
        
        inOrder(root.left,k,count,se);
    
        count[0]++;
        if(count[0] == k){
            se[0] = root.val;
            return;
        }
         
        inOrder(root.right,k,count,se);
    }
}