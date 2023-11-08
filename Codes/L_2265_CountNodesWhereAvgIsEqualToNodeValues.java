package Codes;

public class L_2265_CountNodesWhereAvgIsEqualToNodeValues {
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
    int count  = 0;

    Pair<Integer,Integer> pair(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }

        Pair<Integer,Integer> leftTree  = pair(root.left);
        Pair<Integer,Integer> rightTree  = pair(root.right);

        int sumNode = leftTree.getKey() + rightTree.getKey() + root.val;
        int countNode = leftTree.getValue() + rightTree.getValue() + 1;

        int avg = sumNode/countNode;

        if(root.val == avg){
            count++;
        }

        return new Pair(sumNode , countNode);

    }
    public int averageOfSubtree(TreeNode root) {
        pair(root);

        return count;
    }
}
