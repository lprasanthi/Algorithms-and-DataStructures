// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/

public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}