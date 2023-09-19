import javax.swing.tree.TreeNode;

public class L_110_BalencedBinaryTree {
     public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        // if the height is -1 then false otherwise true
        if(depth(root) == -1){
            return false;
        }
        return true;
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        // finding left height and right height of the tree
        int leftH = depth(root.left);
        int rightH = depth(root.right);

        // if they become/are -1 then returning -1
        if(leftH == -1 || rightH == -1){
            return -1;
        }
        // if the difference of left height and right height is > 1 then it does not satisfy the balenced tree condition
        if(Math.abs(leftH - rightH) > 1){
            return -1;
        }
        //returning height of the tree 
        return Math.max(leftH,rightH)+1;
    }
}
