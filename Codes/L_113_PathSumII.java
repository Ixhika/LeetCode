package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_113_PathSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> temp = new ArrayList<>();
            dfs(root,targetSum,res,temp);
            return res;
        }
        public void dfs(TreeNode root, int sum,List<List<Integer>> res,List<Integer> temp){
            if(root == null){
                return;
            }
            // Adding root value in list
            temp.add(root.val);
            // Checking if root value added is equal to sum or not and it is a leaf node or not
            if(sum == root.val && root.left==null && root.right==null){
                res.add(new ArrayList<>(temp));
            }else{
                // Traversing through left and right children to check the paths : sum-root.val to checking remaining sum left to check
                dfs(root.left,sum - root.val,res,temp);
                dfs(root.right,sum - root.val,res,temp);
            }
            // Checking combinations, if found removing one node and adding another to match the target Sum.
            temp.remove(temp.size()-1);
    } 
}
    
}
