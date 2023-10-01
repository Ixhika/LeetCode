package Codes;

import java.util.Stack;

public class L_230_KthSmallestElementInBST {
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
//   Time complexity: O(n)

// The idea is that we iterate through the BST, we pop from smallest elements and we just need to pop k times to get the k_th smallest element.
    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                n++;

                if(n == k){
                    return curr.val;
                }
            curr = curr.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    // We are going left of every tree/subtree as we have to find smallest and in bst small numbers are to be found on left according to rule of bst
}
