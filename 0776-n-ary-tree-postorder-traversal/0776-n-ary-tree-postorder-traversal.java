/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List <Integer> retList = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        helper(root);

        return retList;
    }

    public void helper(Node root){
        if(root == null)
            return;
        
        for(int i = 0; i < root.children.size();i++){
            helper(root.children.get(i));
        }

        retList.add(root.val);
    }
}