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
    
    public int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int temp = helper(root);
        return maxSum;
    }
    
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int result = Math.max(Math.max(root.val,(root.val+left)),Math.max((root.val+right), (root.val+left+right)));
        
        maxSum = Math.max(maxSum,result);
        
        return  Math.max(Math.max(root.val, root.val+left),root.val+right);
    }
    
}