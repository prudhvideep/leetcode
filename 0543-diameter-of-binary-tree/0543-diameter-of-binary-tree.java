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
    
    public int di = 0;
    
    public int dfs(TreeNode root){
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return 0;
        
        int lh = 1 + dfs(root.left);
        int rh = 1 + dfs(root.right);
        
        int temp = Math.max(lh+rh,Math.max(lh,rh));
        di = Math.max(di,temp);
                
        return Math.max(lh,rh);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int h = dfs(root);
        return di;
    }
}