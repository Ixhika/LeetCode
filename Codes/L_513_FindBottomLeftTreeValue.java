package Codes;

import java.util.LinkedList;
import java.util.Queue;

/*Iterative Approach(Using Level Order Traversal):
Follow the below steps to solve the above problem:
1) We simply traverse the tree using Level Order Traversal with queue data structure.
2) If current node has left child then we update our answer with left child.
3) Finally return the ans node. */

public class L_513_FindBottomLeftTreeValue {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                TreeNode curr = queue.poll();

                if(i == 0){   //this condition shows that we reached last left node of a specific level
                    res = curr.val;
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }
}
