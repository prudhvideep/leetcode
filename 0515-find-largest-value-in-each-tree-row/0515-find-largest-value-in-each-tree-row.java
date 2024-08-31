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
        List <Integer> list = new ArrayList<>();
        Queue <TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return list;
        }

        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            int maxEle = Integer.MIN_VALUE;

            while(n-- > 0){
                TreeNode temp = q.poll();
                maxEle = Math.max(maxEle,temp.val);

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            list.add(maxEle);
        }
        return list;
    }
}