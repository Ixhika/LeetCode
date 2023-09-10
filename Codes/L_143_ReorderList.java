package Codes;

public class L_143_ReorderList {
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    public void reorderList(ListNode head) {
        // Finding the middle value of the list 
        // in 1->2->3->4->5->6 find 4
                ListNode slow = head;
                ListNode fast = head.next;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
        /*Second half rotation after getting the middle value of the list
         convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
         reverse the second half in-place */ 
                ListNode end = slow.next;
                ListNode prev = null;
                slow.next = null;
                while (end != null) {
                    ListNode temp = end.next;
                    end.next = prev;
                    prev = end;
                    end = temp;
                }
        // Reassigning pointers to the list
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
                ListNode start = head;
                end = prev;
                while (end != null) {
                    ListNode temp1 = start.next;
                    ListNode temp2 = end.next;
                    start.next = end;
                    end.next = temp1;
                    start = temp1;
                    end = temp2;
                }
            }
}
