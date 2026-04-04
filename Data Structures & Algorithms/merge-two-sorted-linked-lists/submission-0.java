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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();

        ListNode temp = head;

        while(list1 != null && list2 != null) {
            int x = list1.val;
            int y = list2.val;
            ListNode t;
            if(x < y) {
                t = new ListNode(x);
                list1 = list1.next;
            } else {
                t = new ListNode(y);       
                list2 = list2.next;
            }
            temp.next = t;
            temp = temp.next;
        }
        while(list1 != null) {
            ListNode t = new ListNode(list1.val);
            temp.next = t;
            temp = temp.next; 
            list1 = list1.next;
        }

        while(list2 != null) {
            ListNode t = new ListNode(list2.val);
            temp.next = t;
            temp = temp.next; 
            list2 = list2.next;
        }
        return head.next;
    }
}