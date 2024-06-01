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
    
    
    public int maxPathSum(TreeNode root) {
        int [] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        helper(root,max);
        
        return max[0];
    }
    
    
    public int helper(TreeNode root, int [] max){
        if(root == null) return 0;
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        
        int result = Math.max(Math.max(root.val,(root.val+left)),Math.max((root.val+right), (root.val+left+right)));
        
        max[0] = Math.max(max[0],result);
        
        return  Math.max(Math.max(root.val, root.val+left),root.val+right);
    }
    
}