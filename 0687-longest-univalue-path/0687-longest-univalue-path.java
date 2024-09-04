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
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        getUniPath(root);
        return maxLen;
    }

    public int getUniPath(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 0;
        
        int left = getUniPath(root.left);
        int right = getUniPath(root.right);
        
        int lLen = 0, rLen = 0;

        if(root.left != null && root.left.val == root.val)
            lLen = 1+left;

        if(root.right != null && root.right.val == root.val)
            rLen = 1+right;

        maxLen = Math.max(maxLen,(rLen + lLen));

        return Math.max(rLen,lLen);
    }
}