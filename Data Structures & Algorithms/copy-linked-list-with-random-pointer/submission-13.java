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
/*
 1. Make a copy in the first iteration
    a. Store the orginal node along with its newly created copy in a hash map
 2. Assign Random node in the second iteration
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head ==null) return null;
        HashMap<Node,Node> map = new HashMap<>();// map of orginal node mapped to its corresponding copy
        
        // Make a copy without the random node filled
        Node copyCurr, copyPrev = null;
        Node curr = head;
        while(curr != null){
            copyCurr  = new Node(curr.val);
            if(copyPrev !=null){ //if there is a previous node then the next value of that would be the current node
                copyPrev.next = copyCurr;
            }
            map.put(curr,copyCurr);
            copyPrev = copyCurr;
            curr = curr.next;
            
        }
        //Assign the random node
        curr = head;// reset curr to the first node
        Node randomNode;
        while(curr != null){
            copyCurr = map.get(curr);
            randomNode = map.get(curr.random);
            copyCurr.random = randomNode;
            curr= curr.next;
        }
        return map.get(head);
    }
}
