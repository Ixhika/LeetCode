package Codes;

public class L_2816_DoubleANumberRepresentedAsLinkedList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode doubleIt(ListNode head) {
        if(solve(head) == 1){
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }
    public int solve(ListNode head){
        if(head == null){
            return 0;
        }
        int curr = head.val*2 + solve(head.next);
        if(curr > 9){
            head.val = curr - 10;
        }else{
            head.val = curr;
        }
        if(curr > 9){
            return 1;
        }
        return 0;
    }
}