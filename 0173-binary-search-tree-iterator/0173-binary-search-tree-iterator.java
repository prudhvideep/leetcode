/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {
  public int id = 0;
  List<TreeNode> list = new ArrayList<>();

  public BSTIterator(TreeNode root) {
    list.add(new TreeNode(Integer.MIN_VALUE));
    inOrder(root);
  }

  public void inOrder(TreeNode root) {
    if (root == null)
      return;

    inOrder(root.left);

    list.add(root);

    inOrder(root.right);
  }

  public int next() {
    id++;
    return list.get(id).val;
  }

  public boolean hasNext() {
    if (id < list.size() - 1) {
      return true;
    }

    return false;
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */