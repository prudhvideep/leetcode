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
    public void preOrder(TreeNode root1, TreeNode root2, int level){
        if(root1 == null || root2 == null)
            return;
        
            
        if(level%2 == 0){
            int temp = root1.val;
            root1.val =root2.val;
            root2.val = temp;
        }
        
        preOrder(root1.left,root2.right,level+1);
        preOrder(root1.right,root2.left,level+1);
    }
    
    
    public TreeNode reverseOddLevels(TreeNode root) {
        
        preOrder(root.left,root.right,0);
        
        return root;
    }
}