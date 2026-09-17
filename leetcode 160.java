/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr=headA;
        int len1=0;
        while(curr!=null){
            len1++;
            curr=curr.next;

        }

        curr=headB;
        int len2=0;
        while(curr!=null){
            len2++;
            curr=curr.next;
        }
        ListNode ans=null;
       
        int diff=Math.abs(len1-len2);
        ListNode slow=headA;
        ListNode fast=headB;

        if(len1>len2){
            for(int i=0;i<diff;i++){
                slow=slow.next;
            }

        }
        else{
             for(int i=0;i<diff;i++){
                fast=fast.next;
            }
        }

        
        
            while(fast!=null&&slow!=null){
                if(fast==slow){
                   return ans=slow;

                }
                fast=fast.next;
                slow=slow.next;

            }
        
        return ans;

    }
}