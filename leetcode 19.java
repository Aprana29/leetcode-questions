class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode curr=head;

        while(curr!=null){
            count++;
            curr=curr.next;
        }

        ListNode dummy=new ListNode(0);
         curr=dummy;
         dummy.next=head;


         int a=count-n;
         for(int i=0;i<a;i++){
            curr=curr.next;
         }
         curr.next=curr.next.next;

        return dummy.next;

    }
}