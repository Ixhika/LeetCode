package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_1382_BalenceBinarySearchTree {
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
   List<TreeNode> res = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedBST(0 , res.size()-1);
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        res.add(root);
        inorder(root.right);
    }
    public TreeNode sortedBST(int start , int end){
        if(start > end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = res.get(mid);
        root.left = sortedBST(start,mid-1);
        root.right = sortedBST(mid+1,end);

        return root;
    } 
}
