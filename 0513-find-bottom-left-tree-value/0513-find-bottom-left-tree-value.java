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
    private int maxLevel = 0;
    private int val = 0;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root,1);
        
        return val;
    }
    
    public void traversal(TreeNode root,int level){
        if(root == null)
            return;
        
        if(level > maxLevel){
            val = root.val;
            maxLevel = level;
        }
        
        traversal(root.left,level+1);
        traversal(root.right,level+1);
    }
    
}