package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_872_LeafSimilarTree {
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            // checking if the sorted order for the tree leaves is same or not
            List<Integer> tree1 = new ArrayList<>();
            List<Integer> tree2 = new ArrayList<>();
            inorder(root1,tree1);
            inorder(root2,tree2);

            return (tree1.equals(tree2));
        }

        // putting values of tree nodes in sorted form using inorder traversal
        public void inorder(TreeNode currNode , List<Integer> list){
            if(currNode == null){
                return;
            }
            if(currNode.left == null && currNode.right == null){
                list.add(currNode.val);
            }
            inorder(currNode.left,list);
            inorder(currNode.right,list);
        }
    }
}
