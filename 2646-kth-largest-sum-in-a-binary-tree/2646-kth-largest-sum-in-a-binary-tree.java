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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new ArrayDeque<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        q.add(root);

        while(!q.isEmpty()){
          int n = q.size();
          long sum = 0;
                         
          while(n-- > 0){
            TreeNode e = q.poll();
            sum+=e.val;

            if(e.left != null){
              q.add(e.left);
            }

            if(e.right != null){
              q.add(e.right);
            }
          }

          if(pq.size() < k){
            pq.add(sum);
          }else{
            if(pq.peek() < sum){
              pq.poll();
              pq.add(sum);
            }
          }
        }

        return pq.size() < k ? -1 : pq.peek();
    }
}