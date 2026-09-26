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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0, carry =0;
        ListNode res, resHead=null,prev=null;

        while(l1!=null || l2!=null){
            int val1 = (l1!=null)? l1.val : 0;
            int val2 = (l2!=null)? l2.val : 0;
            sum = val1 + val2 + carry;
            carry = 0;//Reset carry after every use;
            if(sum<10){
                res = new ListNode(sum);
            }else{
                res = new ListNode(sum%10);
                carry = sum/10;
            }
            if(prev==null){
                resHead= res;
            }
            else{
                prev.next = res;
            }
            prev = res;
            //Don't increment list when the pointers are null
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry>0){
            res = new ListNode(carry);
            prev.next = res;
        }

        return resHead;
    }
}
