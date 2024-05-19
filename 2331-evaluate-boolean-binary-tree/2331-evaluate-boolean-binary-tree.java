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
    public boolean evaluateTree(TreeNode root) {
        helper(root);
       
        if(root != null) return (root.val == 1) ? true : false;
        
        return false;
    }
    
    void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        helper(root.right);
        
        if((root.left != null && (root.left.val == 0 || root.left.val == 1))
           && (root.right != null && (root.right.val == 0 || root.right.val == 1))){
            int a = root.left.val;
            int b = root.right.val;
            
            if(root.val == 2){
                root.val = a | b;
            }else if(root.val == 3){
                root.val = a & b;
            }
            
            root.left = null;
            root.right = null;
        }
    }
}