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
    public List<Integer> largestValues(TreeNode root) {
        List <Integer> list = new ArrayList <> ();

        dfs(root,0,list);

        return list;
    }

    public void dfs(TreeNode root, int level, List <Integer> list){
        if(root == null) return;
        
        if(list.size() <= level){
            list.add(root.val);
        }else{
            int maxEle = Math.max(list.get(level),root.val);
            list.set(level,maxEle);
        }

        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);
    }
}