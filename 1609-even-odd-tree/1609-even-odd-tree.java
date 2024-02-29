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
    public boolean isEvenOddTree(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0,prev;
        while(!q.isEmpty()){
           int n = q.size();
           if(level%2 == 0){
               prev = Integer.MIN_VALUE;
           }else{
               prev = Integer.MAX_VALUE;
           }
           while(n > 0){
               TreeNode temp = q.poll();
               //System.out.println(temp.val);
               if(level%2 == 1){
                   if(temp.val%2 != 0){
                       return false;
                   }
                   if(prev <= temp.val){
                       return false;
                   }
               }else if(level%2 == 0){
                   if(temp.val%2 == 0){
                       return false;
                   }
                   if(prev >= temp.val){
                       return false;
                   }
               }
                   
               prev = temp.val;
               if(temp.left != null)
                   q.add(temp.left);
               if(temp.right != null)
                   q.add(temp.right);
               
               n--;
           }
           level++;
        }
        return true;
    }
}