/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue <Node> q = new LinkedList <> ();
        q.add(root);
        Node prev = null, cur = null;

        while(!q.isEmpty()){
            int n = q.size();
            prev = null;
            cur = null;
            while(n > 0){
                cur = q.poll();
                cur.next = null;

                if(prev != null){
                    prev.next = cur;
                } 

                if(cur.left != null){
                    q.add(cur.left);
                }

                if(cur.right != null){
                    q.add(cur.right);
                }

                prev = cur;

                n--;
            }

        }

        return root;
        
    }
}