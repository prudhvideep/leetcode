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
    public int rob(TreeNode root) {
       Pair ret = helper(root); 

       return Math.max(ret.a,ret.b);      
    }

    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        Pair result = new Pair(0,0);
       
        //With root
        result.a = root.val + (left.b + right.b);
        //without root 
        result.b = Math.max(left.a,left.b) + Math.max(right.a,right.b);

        return result;
        
    }

    class Pair{
        int a;
        int b;

        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
}