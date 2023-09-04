package Codes;

public class L_100_SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if roots of both the tree are null they are same as null == null
        if(p == null && q == null){
            return true;
        }
        // If one is null and other is given no comparison will be there thus it will return false and it also proves that both tree are not same
        if(p == null || q == null){
            return false;
        }
        // if the value both tree are equal.
        if(p.val == q.val){

            // Doing a recursive of left and right subtrees for both trees and it will check if they are equal from the above if condition
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
