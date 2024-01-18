package Codes;

public class L_116_PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    
    class Solution {
        public Node connect(Node root) {
            /*The first condition checks if the current root is not null and has a left child.
If true, it connects the left child's next pointer to the right child.
It then checks if the current node has a next pointer (i.e., it's not a leaf node).
If true, it connects the right child's next pointer to the left child of the next node in the same level.
Finally, the method is recursively called on the left and right children */
            if(root != null && root.left != null){
                root.left.next = root.right;
            
                if(root.next != null){
                    root.right.next = root.next.left;
                }
                connect(root.left);
                connect(root.right);
            }
            return root;
        }
    }
}


// BFS using queue in form linked list
  /*class Solution {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                Node rightN = null;
                for(int i=queue.size();i>0;i--){
                    Node curr = queue.poll();
                    curr.next = rightN;
                    rightN = curr;
                    if(curr.right != null){
                        queue.offer(curr.right);
                        queue.offer(curr.left);
                    }
                }
            }
            return root;
        }
    } */