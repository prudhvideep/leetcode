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
    public boolean isValidBST(TreeNode root) {
       long max = Long.MAX_VALUE, min = Long.MIN_VALUE;
       return helper(root,max,min);
    }
    
    public boolean helper(TreeNode root,long max,long min){
        if(root == null){
            return true;
        }

        if(helper(root.left,root.val,min) == false){
            return false;
        }

        if(root.val >= max || root.val <= min){
            return false;
        }

        return helper(root.right,max,root.val);
    }
    
}