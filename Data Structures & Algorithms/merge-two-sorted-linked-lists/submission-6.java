class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempStart = new ListNode();//only a place holder to start the new list
        ListNode tail = tempStart;
        
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
               tail.next = list1;
               list1= list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1!=null? list1:list2;//because we exit the loop when only one of the list is null, we still would need to allocate the other list
        return tempStart.next; // here since tempStart is empty/placeholder, the actual new list starts from the next node of tempStart.
    }
}