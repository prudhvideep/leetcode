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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> al = new ArrayList<>();
        if(root == null)
            return al;
        
        Queue <TreeNode> q = new ArrayDeque<>();
        List <Integer> l = new ArrayList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                TreeNode temp = q.poll();
                l.add(temp.val);
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            al.add(new ArrayList <Integer> (l));
            l.clear();
        }
        return al;
    }
}