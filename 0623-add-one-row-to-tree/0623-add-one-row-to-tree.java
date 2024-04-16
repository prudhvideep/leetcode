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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        ArrayDeque <TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        if(depth == 1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        
        int count = 1;
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                TreeNode temp = q.poll();
                if(count == depth-1){
                    TreeNode temp_left = temp.left;
                    TreeNode temp_right = temp.right;
                    
                    temp.left = new TreeNode(val);
                    temp.right = new TreeNode(val);
                    
                    temp.left.left = temp_left;
                    temp.right.right = temp_right;
                }else{
                    if(temp.left != null) q.add(temp.left);
                    
                    if(temp.right != null) q.add(temp.right);   
                }
                
                n--;
            }
            
            if(count == depth-1)break;
            
            count++;
        }
        
        return root;
    }
}