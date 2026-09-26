/*
    1. Find the mid point of the list using fast and slow pointer
    2. After finding the mid point we split the list at the middle , the slow pointer will be the head of the second list 
    3. we reverese the second list.
    4. We iterate over the first list, and allocate the corresponding second list node as their next node.
*/

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast= head,slow = head;
        //Finding the mid point of the list
        while(fast.next != null && fast.next.next != null){
            fast= fast.next.next;
            slow = slow.next;
        }// so slow is where the first list ends and slow.next is where second list begins
        ListNode l1= head,l2=slow.next;// split the list into two list at the mid point
        slow.next = null; // cut the connection between the two list

        //reverse the second list
        ListNode curr = l2;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        l2 = prev;// update l2 to the new head of the reversed list

        //merge the two list
        while(l2 != null){
            ListNode tempL1 = l1.next;
            ListNode tempL2 = l2.next;
            l2.next = l1.next;
            l1.next= l2;
            l1 = tempL1;
            l2=tempL2;
        }
    }
}
