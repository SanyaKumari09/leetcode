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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode leftPre=dummy;
        ListNode currNode=head;

        for(int i=0;i<left-1;i++){
            leftPre=leftPre.next;
            currNode=currNode.next;
        }

        ListNode sublistHead=currNode;
        ListNode prevNode=null;

        for(int i=0;i<=right-left;i++){
            ListNode next=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=next;
        }

        leftPre.next=prevNode;
        sublistHead.next=currNode;

        return dummy.next;

    }
}