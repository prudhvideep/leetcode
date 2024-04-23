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
    int id = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        
        int leftVal = kthSmallest(root.left,k);
        if(leftVal != -1) return leftVal;
        if(++id == k) return root.val;
        return kthSmallest(root.right,k);
    }
}