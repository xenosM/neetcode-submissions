/*
    1. with each iteration check if count matches targeted value if it is delete it, and if  not count++
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode l = dummy,r= head;
        //Set r at an offset of n (technically n+1) from l
        while(n>0 && r!=null){
            r=r.next;
            n--;
        }
        while(r!=null){
            l=l.next;
            r=r.next;
        }
        //to remove the element
        l.next = l.next.next;
        return dummy.next; // not head because head might change
    }
}
