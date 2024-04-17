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
    public String retString = "";
    
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder ();
        helper(root,sb);
        return retString;
    }
    
    public void helper(TreeNode root,StringBuilder sb){
        if(root == null)
            return;
        
        int x = root.val;
        char c = (char) ('a' + x);
        sb.insert(0,c);
        
        //System.out.println(sb);
        if(root.left == null && root.right == null){
            if(retString == null || retString.length() == 0){
                retString = sb.toString();
            }else if(retString.compareTo(sb.toString()) > 0){
                retString = sb.toString();
            }
        }
        
        helper(root.left,sb);
        helper(root.right,sb);
        
        sb.deleteCharAt(0);
    }
}