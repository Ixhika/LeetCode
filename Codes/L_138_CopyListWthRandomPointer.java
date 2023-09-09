package Codes;

import java.util.HashMap;

import org.w3c.dom.Node;

public class L_138_CopyListWthRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
     public Node copyRandomList(Node head) {
        Node curr = head;
// Creating a map to store all the values of the given linked list
        HashMap<Node, Node> map = new HashMap<>();
        while (curr != null) {

// Creating a deep copy of each node that is in given linked list.
            /* 7->13->11->10->1->null
            copy linked: 7 -> 13->.... each getting copied by creating a newNode after each iteration */
            // Every old node is mapped with new node

            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;  //Setting the linked list back to head to traverse again and set next and random pointers.
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);  //using this to map old node next with the copied current node.next
            map.get(curr).random = map.get(curr.random);  //using this to map old node random with the copied current node.random
            curr = curr.next;
        }

        return map.get(head);  //taking head of the original linked list and then mapping it to copy linked list
    }
}
