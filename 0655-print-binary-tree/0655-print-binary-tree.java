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
    public int getHeight(TreeNode root){
        if(root == null){
            return  -1;
        }

        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);

        int m = h+1;
        int n = ((int) Math.pow(2,(h+1))) -1;

        List<List<String>> ret = new ArrayList<>();
        List <String> col = new ArrayList <> ();

        for(int i = 0;i < n;i++){
            col.add("");
        }

        for(int i = 0;i < m;i++){
            ret.add(new ArrayList <> (col));
        }

        dfs(root,0,(n-1)/2,h,ret);

        return ret;
    }

    public void dfs(TreeNode root,int r,int c,int h,List<List<String>> ret){
        if(root == null)
            return;
        
        ret.get(r).set(c,"" + root.val);

        int s = (int) Math.pow(2,(h-r-1));

        dfs(root.left, r+1, c-s, h, ret);
        dfs(root.right,r+1, c+s, h, ret);
    }


}