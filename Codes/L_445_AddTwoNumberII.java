package Codes;

import java.util.Stack;

public class L_445_AddTwoNumberII {
    // Time Complexity: O(m+n)

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Creating two stacks for two ll and pushing their values
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode();
        while(!s1.isEmpty() || !s2.isEmpty()){
            // adding values one by one
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            // in result list putting the values accordingly and taking carry for further additions
            res.val = sum % 10;
            carry = sum/10;
            ListNode head = new ListNode(carry);
            // shifting the node to next for next numbers in resultant list
            head.next = res;
            res = head;
            sum = carry;
        }
        if(carry == 0){
            res = res.next;
        }
        return res;
    }
}
