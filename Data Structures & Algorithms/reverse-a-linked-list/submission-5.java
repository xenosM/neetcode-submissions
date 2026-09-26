/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prevNode = null; // the previous node of the head will always be null
      while(head !=null){
        ListNode tempNode = head.next;
        head.next = prevNode;
        prevNode = head ; // Setting the previous node for the next Node in the Linked list as the current head node
        head = tempNode;
      }

      return prevNode;
    }
}
