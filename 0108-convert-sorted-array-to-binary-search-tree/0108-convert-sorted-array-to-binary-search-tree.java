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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        TreeNode root = buildTree(nums,0,n-1);
        
        return root;
    }
    
    public TreeNode buildTree(int [] nums, int l, int h){
        if(l > h)
            return null;
        
        if(l == h){
            return new TreeNode(nums[l],null,null);
        }
        
        int mid = l + (h-l)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildTree(nums,l,mid-1);
        root.right = buildTree(nums,mid+1,h);
        
        return root;
    }
}