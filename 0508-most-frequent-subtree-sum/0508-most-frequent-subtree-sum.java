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
    public Map <Integer,Integer> map = new HashMap <> ();
    public int[] findFrequentTreeSum(TreeNode root) {
        int totSum = findSum(root);

        Set <Integer> set = new HashSet<>();
        
        int fq = 0;
        for(int key : map.keySet()){
            if(map.get(key) >= fq){
                if(map.get(key) == fq){
                    set.add(key);
                }else{
                    set.clear();
                    set.add(key);
                    fq = map.get(key);
                }
            }
        }

        int [] ret = new int [set.size()];

        int id = 0;
        for(int e : set){
            ret[id++] = e;
        }
        
        return ret;
    }


    public int findSum(TreeNode root){
        if(root == null)
            return 0;

        int lSum = findSum(root.left);
        int rSum = findSum(root.right);

        int totSum = root.val + lSum + rSum;

        map.put(totSum,map.getOrDefault(totSum,0)+1);

        return totSum;
    }
}