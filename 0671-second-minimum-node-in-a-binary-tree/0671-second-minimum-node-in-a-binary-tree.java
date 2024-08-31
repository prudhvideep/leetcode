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
    public int findSecondMinimumValue(TreeNode root) {
        long [] minA = new long[2];
        Arrays.fill(minA,Long.MAX_VALUE);
        dfs(root,minA);

        if(minA[1] != Long.MAX_VALUE){
            return (int) minA[1];
        }

        return -1;
    }

    public void dfs(TreeNode root,long [] minA){
        if(root == null)
            return;

        if(root.val <= minA[0]){
            if(root.val != minA[0]){
                minA[1] = minA[0];
                minA[0] = root.val;
            }
        }else{
            if(root.val < minA[1]){
                minA[1] = root.val;
            }
        }

        dfs(root.left,minA);
        dfs(root.right,minA);
    }
}