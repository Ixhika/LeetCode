package Codes;

public class L_1457_PseudoPalindromePathsInBinaryTree {
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
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        solve(root,count);
        return res;
    }
    public void solve(TreeNode root , int[] count){
        // creating an array to count frequencies of element in given path 
        if(root != null){
            count[root.val]++;
        
            
            if(root.left == null && root.right == null){
                int pseudoPalin = 0;
                for(int i=1;i<=9;i++){
                    if(count[i] % 2 != 0){
                        pseudoPalin++;
                    }
                }
                if(pseudoPalin <= 1){
                    res += 1;
                }else{
                    res += 0;
                }
            }
            solve(root.left,count);
            solve(root.right,count);

            count[root.val]--;
        }
    }
}
