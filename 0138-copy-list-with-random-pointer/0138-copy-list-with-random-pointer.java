/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap <Node,Node> hm = new HashMap<>();

        Node temp = head;

        while(temp != null){
            hm.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        Node newHead = hm.get(head);
        temp = head;

        while(temp != null){
            Node next = temp.next;
            Node random = temp.random;
            if(next != null){
                hm.get(temp).next = hm.get(next);
            }
            
            if(random != null){
                hm.get(temp).random = hm.get(random);
            }  

            temp = temp.next;  
        }

        return newHead;
    }
}