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
    public String retString;
    
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
            checkLexi(sb);
        }
        
        helper(root.left,sb);
        helper(root.right,sb);
        
        sb.deleteCharAt(0);
    }
    
    public void checkLexi(StringBuilder sb){
        if(retString == null || retString.length() == 0){
            retString = sb.toString();
            return;
        }
        System.out.println(retString);
        
        String sbStr = sb.toString();
        int len = Math.min(retString.length(),sbStr.length());
        
        for(int i = 0;i < len;i++){
            if(retString.charAt(i) > sbStr.charAt(i)){
                retString = sbStr;
                return;
            }else if(retString.charAt(i) < sbStr.charAt(i)){
                return;
            }
        }
        
        if(retString.length() > sbStr.length())
            retString = sbStr;
    }
}