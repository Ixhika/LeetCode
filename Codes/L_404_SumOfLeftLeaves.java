import javax.swing.tree.TreeNode;

//  For given node we check whether its left child is a leaf. If it is the case, we add its value to answer, 
//  otherwise recursively call method on left child. For right child we call method only if it has at least one nonnull child.

public class L_404_SumOfLeftLeaves {
     public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } 
        int ans = 0;
        // Checking for left subtree and whether it is a leave or not
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null){
                ans += root.left.val;
            } 
            else{
                ans += sumOfLeftLeaves(root.left);
            } 
        }
        // traversing over right subtree left part.
        ans += sumOfLeftLeaves(root.right);
    
    return ans;
    }
}

/*  3
   / \
  9   20
      / \
    15   7

Sum: 9+15 = 24*/
